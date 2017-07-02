grammar Quartz;

// PARSER

program
    : importDeclaration* declaration*
    ;

// DECLARATIONS

declaration
    : functionDeclaration
    | externFunctionDeclaration
    | typealiasDeclaration
    | inlineC
    ;

// FN DECLARATION

functionDeclaration
    : 'fn' NAME '(' nameTypeList? ')' (':' returnType=type)? expression
    ;

externFunctionDeclaration
    : 'extern' 'fn' NAME '(' typeList? ')' (':' returnType=type)?
    ;

// TYPEALIAS DECLARATION

typealiasDeclaration
    : 'typealias' NAME '=' type
    ;

// IMPORT DECLARATION

importDeclaration
    : 'import' packageList
    ;

packageList
    : NAME ('.' packageList)?
    ;

// EXPRESSIONS

expression
    : letExpression
    | delegateExpression
    ;

delegateExpression
    : assignmentExpression (',' delegateExpression)?
    ;

assignmentExpression
    : disjunction (assignmentOperation assignmentExpression)?
    ;

disjunction
    : conjunction (disjunctionOperation disjunction)?
    ;

conjunction
    : equalityComparison (conjunctionOperation conjunction)?
    ;

equalityComparison
    : comparison (equalityOperation equalityComparison)?
    ;

comparison
    : bitshiftExpression (comparisonOperation comparison)?
    ;

bitshiftExpression
    : additiveExpression (bitshiftOperation bitshiftExpression)?
    ;

additiveExpression
    : multiplicativeExpression (additiveOperation additiveExpression)?
    ;

multiplicativeExpression
    : operableExpression (multiplicativeOperation multiplicativeExpression)?
    ;

operableExpression
    : prefixOperation operableExpression
    | operableExpression postfixOperation
    | atomicExpression
    ;

atomicExpression
    : '(' expression ')'
    | inlineC
    | literal
    | sizeof
    | identifier
    | ifExpression
    ;

letExpression
    : ( 'let' nameType
      | 'let' nameOptionalType '=' value=expression
      ) 'in' expr=expression
    ;

ifExpression
    : 'if' ifBranch+ ('else' '{' expression '}')?
    ;

ifBranch
    : condition=expression '{' ifTrue=expression '}'
    ;

literal
    : STRING
    | CHAR
    | INT
    | DOUBLE
    ;

sizeof
    : 'sizeof' '(' type ')'
    ;

assignmentOperation
    : '='
    | '+='
    | '-='
    | '*='
    | '/='
    | '%='
    | '&='
    | '|='
    | '^='
    | '<' '<' '='
    | '>' '>' '='
    ;

disjunctionOperation
    : '||'
    | '|'
    | '^'
    ;

conjunctionOperation
    : '&&'
    | '&'
    ;

equalityOperation
    : '=='
    | '!='
    ;

comparisonOperation
    : '>'
    | '<'
    | '>' '='
    | '<' '='
    ;

bitshiftOperation
    : '>' '>'
    | '<' '<'
    ;

additiveOperation
    : '+'
    | '-'
    ;

multiplicativeOperation
    : '*'
    | '/'
    | '%'
    ;

prefixOperation
    : '-'
    | '!'
    | '~'
    ;

postfixOperation
    : cast
    | postfixCall
    | dotCall
    ;

cast
    : 'as' type
    ;

postfixCall
    : ('(' ')'|atomicExpression+)
    ;

dotCall
    : '.' identifier postfixCall
    ;

// TYPES

type
    : NAME
    | INLINE_C
    | primitiveType
    | functionType
    | pointerType
    | constType
    ;

pointerType
    : '*' type
    ;

constType
    : 'const' type
    ;

primitiveType
    : boolType='bool'
    | charType='char'
    | shortType='short'
    | intType='int'
    | longType='long'
    | ucharType='uchar'
    | ushortType='ushort'
    | uintType='uint'
    | ulongType='ulong'
    | floatType='float'
    | doubleType='double'
    | voidType='void'
    ;

functionType
    : '(' args=typeList? ')' '->' returnType=type
    ;

// LISTS

nameTypeList
    : nameType (',' nameTypeList)?
    ;

nameOptionalTypeList
    : nameOptionalType (',' nameOptionalTypeList)?
    ;

expressionList
    : expression (',' expressionList)?
    ;

nameList
    : NAME (',' nameList)?
    ;

typeList
    : type (',' typeList)?
    | vararg='...'
    ;

genericArgumentList
    : genericArgument (',' genericArgumentList)?
    ;

// UTIL

nameType
    : NAME ':' type
    ;

nameOptionalType
    : NAME (':' type)?
    ;

genericArgument
    : NAME
    ;

identifier
    : NAME
    ;

inlineC
    : INLINE_C
    ;

// LEXER

DMOD: '%%';
STRING: '"' ('\\'.|.)*? '"';
CHAR: '\'' ('\\'.|.)*? '\'';
INT: [0-9]+;
DOUBLE: [0-9]*'.'[0-9]+;
INLINE_C: DMOD .*? DMOD;

NAME: ([_a-zA-Z][_a-zA-Z0-9]*);

// WHITESPACE

BLOCK_COMMENT:'/*' .*? '*/'-> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
WHITESPACE:[ \r\n\t]+ -> skip;
