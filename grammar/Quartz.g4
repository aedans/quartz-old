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
    : 'fn' name=NAME NAME* ':' functionType expression
    ;

externFunctionDeclaration
    : 'extern' 'fn' NAME ':' functionType
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
    | disjunction
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
    : delegateExpression (comparisonOperation comparison)?
    ;

delegateExpression
    : statementExpression (delegateOperation delegateExpression)?
    ;

statementExpression
    : ifExpression
    | whenExpression
    | assignmentExpression
    ;

assignmentExpression
    : bitshiftExpression (assignmentOperation assignmentExpression)?
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
    | operableExpression atomicPostfixOperation
    | atomicExpression postfixOperation?
    ;

atomicExpression
    : '(' expression ')'
    | inlineC
    | literal
    | sizeof
    | identifier
    ;

letExpression
    : 'let' NAME
        ( ':' type
        | (':' type)? '=' value=expression
        ) 'in' expr=expression
    ;

ifExpression
    : 'if' condition=expression 'then' ifTrue=expression 'else' ifFalse=statementExpression
    ;

whenExpression
    : 'when' condition=atomicExpression ifTrue=statementExpression
    ;

literal
    : STRING
    | CHAR
    | INT
    | DOUBLE
    ;

sizeof
    : 'sizeof' '<' type '>'
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

delegateOperation
    : ';'
    ;

assignmentOperation
    : '='
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
    : atomicPostfixOperation
    | postfixCall
    | dotCall
    ;

atomicPostfixOperation
    : cast
    | atomicPostfixCall
    | atomicDotCall
    ;

cast
    : 'as' type
    ;

atomicPostfixCall
    : '(' ')'
    ;

atomicDotCall
    : '.' identifier atomicPostfixCall
    ;

postfixCall
    : atomicPostfixCall
    | atomicExpression+
    ;

dotCall
    : atomicDotCall
    | '.' identifier postfixCall?
    ;

// TYPES

type
    : atomicType
    | functionType
    ;

atomicType
    : '(' type ')'
    | NAME
    | INLINE_C
    | primitiveType
    | pointerType
    | constType
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

pointerType
    : '*' atomicType
    ;

constType
    : 'const' atomicType
    ;

functionType
    : ('(' ')'|atomicTypeList (vararg='...')?) '->' type
    ;

// LISTS

nameList
    : NAME (',' nameList)?
    ;

atomicTypeList
    : atomicType (',' atomicTypeList)?
    ;

// UTIL

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

NAME: [_a-zA-Z][_a-zA-Z0-9]*;

// WHITESPACE

BLOCK_COMMENT:'/*' .*? '*/'-> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
WHITESPACE:[ \r\n\t]+ -> skip;
