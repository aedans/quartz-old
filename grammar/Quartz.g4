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
    : 'fn' ('<' nameList '>')? NAME '(' fnArgumentList ')' (':' returnType=type)? fnBlock
    ;

externFunctionDeclaration
    : 'extern' signatureDefinition
    ;

signatureDefinition
    : 'fn' NAME '(' typeList ')' (':' returnType=type)? semi?
    ;

fnArgument
    : (NAME ':' type)
    ;

fnArgumentList
    : (fnArgument ',')* fnArgument?
    ;

fnBlock
    : block
    | '=' expression semi?
    ;

// STRUCT DECLARATION

structDeclaration
    : extern='extern'? 'struct' NAME ('<' nameList '>')? '{' structMember* '}' semi?
    ;

structMember
    : varDeclarationType NAME ':' type semi?
    ;

// TYPEALIAS DECLARATION

typealiasDeclaration
    : extern='extern'? 'typealias' NAME '=' type semi?
    ;

// IMPORT DECLARATION

importDeclaration
    : 'import' packageList semi?
    ;

packageList
    : (NAME '.')* NAME
    ;

// STATEMENTS

statement
    : inlineC semi?
    | returnStatement semi?
    | varDeclaration semi?
    | ifStatement semi?
    | whileLoop semi?
    | breakStatement semi?
    | continueStatement semi?
    | expression semi?
    ;

varDeclaration
    : varDeclarationType identifier (':' type)? '=' expression
    ;

returnStatement
    : 'return' expression
    ;

ifStatement
    : 'if' '(' expression ')' trueBlock=block ('else' falseBlock=block)?
    ;

whileLoop
    : 'while' '(' expression ')' block
    ;

breakStatement
    : 'break'
    ;

continueStatement
    : 'continue'
    ;

// EXPRESSIONS

expression
    : disjunction (assignmentOperator expression)?
    ;

disjunction
    : conjunction ('||' disjunction)?
    ;

conjunction
    : equalityComparison ('&&' conjunction)?
    ;

equalityComparison
    : comparison (equalityOperation equalityComparison)?
    ;

comparison
    : additiveExpression (comparisonOperation comparison)?
    ;

additiveExpression
    : multiplicativeExpression (additiveOperation additiveExpression)?
    ;

multiplicativeExpression
    : prefixExpression (multiplicativeOperation multiplicativeExpression)?
    ;

prefixExpression
    : prefixOperation* postfixExpression
    ;

postfixExpression
    : atomicExpression postfixOperation*
    ;

atomicExpression
    : '(' expression ')'
    | lambda
    | ifExpression
    | sizeof
    | identifier
    | inlineC
    | literal
    ;

assignmentOperator
    : '='
    | '+='
    | '-='
    | '*='
    | '/='
    | '%='
    ;

equalityOperation
    : '=='
    | '!='
    ;

comparisonOperation
    : '>'
    | '<'
    | '>='
    | '<='
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
    : '++'
    | '--'
    | '-'
    | '!'
    ;

postfixOperation
    : '++'
    | '--'
    | postfixCall
    | memberAccess
    | dotCall
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

lambda
    : 'fn' ('(' fnArgumentList ')')? (':' returnType=type)? fnBlock
    ;

ifExpression
    : 'if' '(' test=expression ')' ifTrue=expression 'else' ifFalse=expression
    ;

sizeof
    : 'sizeof' '(' type ')'
    ;

literal
    : STRING
    | CHAR
    | INT
    | DOUBLE
    ;

// TYPES

type
    : isConst='const'? ltype
    ;

ltype
    : NAME ('<' typeList '>')?
    | ltype ptr='*'
    | '(' args=typeList ')' '->' returnType=type
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

// UTIL

block
    : '{' statement* '}' semi?
    | statement
    ;

identifier
    : NAME ('<' typeList '>')?
    ;

inlineC
    : INLINE_C
    ;

varDeclarationType
    : 'var'|'val'
    ;

semi
    : ';'+
    ;

// LEXER

DMOD: '%%';
STRING: '"' ('\\'.|.)*? '"';
CHAR: '\''.'\'';
INT: [0-9]+;
DOUBLE: [0-9]*'.'[0-9]+;
INLINE_C: DMOD .*? DMOD;

NAME: ([_a-zA-Z][_a-zA-Z0-9]*);

// WHITESPACE

BLOCK_COMMENT:'/*' .*? '*/'-> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
WHITESPACE:[ \r\n\t]+ -> skip;
