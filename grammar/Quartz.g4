grammar Quartz;

// PARSER

program
    : importDeclaration* declaration*
    ;

// DECLARATIONS

declaration
    : fnDeclaration
    | externFnDeclaration
    | structDeclaration
    | typealiasDeclaration
    | inlineC
    ;

// FN DECLARATION

fnDeclaration
    : fnModifiers 'fn' identifier '(' fnArgumentList ')' (':' returnType=type)? body=fnBlock
    ;

fnArgument
    : (identifier ':' type)
    ;

fnArgumentList
    : (fnArgument ',')* fnArgument?
    ;

fnModifiers
    :
    ;

fnBlock
    : block
    | '=' expression semi?
    ;

// EXTERN FN DECLARATION

externFnDeclaration
    : fnModifiers 'extern' 'fn' identifier '(' typeList ')' (':' returnType=type)? semi?
    ;

// STRUCT DECLARATION

structDeclaration
    : 'struct' identifier '{' structMember* '}' semi?
    ;

structMember
    : varDeclarationType identifier ':' type semi?
    ;

// TYPEALIAS DECLARATION

typealiasDeclaration
    : 'typealias' identifier '=' type semi?
    ;

// IMPORT DECLARATION

importDeclaration
    : 'import' packageList semi?
    ;

packageList
    : (identifier '.')* identifier
    ;

// STATEMENTS

statement
    : inlineC semi?
    | returnStatement semi
    | varDeclaration semi
    | ifStatement semi?
    | whileLoop semi?
    | expression semi
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

// EXPRESSIONS

expression
    : disjunction
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
    | ifExpression
    | identifier
    | inlineC
    | literal
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
    : '-'
    | '!'
    ;

postfixOperation
    : arrayAccess
    | postfixCall
    | memberAccess
    ;

arrayAccess
    : '[' expression ']'
    ;

postfixCall
    : '(' expressionList ')'
    ;

memberAccess
    : '.' identifier
    ;

ifExpression
    : 'if' '(' test=expression ')' ifTrue=expression 'else' ifFalse=expression
    ;

literal
    : STRING
    | CHAR
    | INT
    | DOUBLE
    ;

// TYPES

type
    : identifier
    | type array='[]'
    | '(' args=typeList ')' '->' returnType=type
    ;

// LISTS

expressionList
    : (expression ',')* expression?
    ;

identifierList
    : (identifier ',')* identifier?
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
    : IDENTIFIER
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

IDENTIFIER: ([_a-zA-Z][_a-zA-Z0-9]*);

// WHITESPACE

BLOCK_COMMENT:'/*' .*? '*/'-> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
WHITESPACE:[ \r\n\t]+ -> skip;
