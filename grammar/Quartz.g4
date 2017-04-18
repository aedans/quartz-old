grammar Quartz;

// PARSER

program
    : importDeclaration* declaration*
    ;

// DECLARATIONS

declaration
    : functionDeclaration
    | structDeclaration
    | typealiasDeclaration
    | destructorDeclaration
    | inlineC
    ;

// FN DECLARATION

functionDeclaration
    : 'fn' ('<' identifierList '>')? identifier '(' fnArgumentList ')' (':' returnType=type)? fnBlock
    | 'extern' signatureDefinition
    ;

signatureDefinition
    : 'fn' identifier '(' typeList ')' (':' returnType=type)? semi?
    ;

fnArgument
    : (identifier ':' type)
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
    : extern='extern'? 'struct' identifier ('<' identifierList '>')? '{' structMember* '}' semi?
    ;

structMember
    : varDeclarationType identifier ':' type semi?
    ;

// TYPEALIAS DECLARATION

typealiasDeclaration
    : extern='extern'? 'typealias' identifier '=' type semi?
    ;

// DESTRUCTOR DECLARATION

destructorDeclaration
    : 'destructor' ('<' identifierList '>')? type fnBlock
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
    | returnStatement semi?
    | varDeclaration semi?
    | ifStatement semi?
    | whileLoop semi?
    | delete semi?
    | typeswitch semi?
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

delete
    : 'delete' expression
    ;

typeswitch
    : 'typeswitch' '(' identifier ')' '{' typeswitchBranch* ('else' block)? '}'
    ;

typeswitchBranch
    : type block
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
    ;

postfixCall
    : ('<' typeList '>')? '(' expressionList ')'
    ;

memberAccess
    : '.' identifier
    ;

lambda
    : 'fn' '(' fnArgumentList ')' (':' returnType=type)? fnBlock
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
    : identifier ('<' typeList '>')?
    | type ptr='*'
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
