grammar Quartz;

// PARSER

program
    : importDeclaration* declaration*
    ;

// DECLARATIONS

declaration
    : functionDeclaration
    | externFunctionDeclaration
    | structDeclaration
    | typealiasDeclaration
    | inlineC
    ;

// FN DECLARATION

functionDeclaration
    : 'fn' NAME ('<' genericArgumentList '>')? '(' fnArgumentList ')' (':' returnType=type)? atomicBlock
    ;

externFunctionDeclaration
    : 'extern' signatureDefinition
    ;

signatureDefinition
    : 'fn' NAME '(' typeList ')' (':' returnType=type)?
    ;

fnArgument
    : (NAME ':' type)
    ;

fnArgumentList
    : (fnArgument ',')* fnArgument?
    ;

// STRUCT DECLARATION

structDeclaration
    : extern='extern'? 'struct' NAME ('<' genericArgumentList '>')? '{' structMember* '}'
    ;

structMember
    : NAME ':' type
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
    : (NAME '.')* NAME
    ;

// EXPRESSIONS

expression
    : varDeclaration
    | returnExpression
    | ifExpression
    | assignmentExpression
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
    | lambda
    | identifier
    ;

varDeclaration
    : 'let' NAME ':' type
    | 'let' NAME (':' type)? '=' expression
    ;

returnExpression
    : 'return' expression
    ;

ifExpression
    : 'if' test=expression 'then' ifTrue=block ('else' ifFalse=block)?
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

lambda
    : ((fnArgumentList|nameList) '->' type?) atomicBlock
    | atomicBlock
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
    : '+'
    | '-'
    | '!'
    | '~'
    ;

postfixOperation
    : cast
    | postfixCall
    | memberAccess
    | dotCall
    ;

cast
    : 'as' type
    ;

postfixCall
    : '(' expressionList ')'
    ;

memberAccess
    : '.' NAME
    ;

dotCall
    : '.' identifier '(' expressionList ')'
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
    : '(' args=typeList ')' '->' returnType=type
    ;

// LISTS

expressionList
    : (expression ',')* expression?
    ;

nameList
    : (NAME ',')* NAME?
    ;

typeList
    : (type ',')* (vararg='...'|type)?
    ;

genericArgumentList
    : (genericArgument ',')* genericArgument?
    ;

// UTIL

genericArgument
    : NAME
    ;

block
    : atomicBlock
    | expression
    ;

atomicBlock
    : '{' (expression ';')* '}'
    ;

identifier
    : NAME ('<' typeList '>')?
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
