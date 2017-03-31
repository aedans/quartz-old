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
    | inlineC
    ;

// FN DECLARATION

fnDeclaration
    : fnModifiers FN name=identifier '(' fnArgumentList ')' (':' returnType=varType)? body=fnBlock
    ;

fnArgument
    : (name=identifier ':' type=varType)
    ;

fnArgumentList
    : (fnArgument ',')* fnArgument?
    ;

fnModifiers
    : FN_MODIFIER*
    ;

fnBlock
    : block
    | '=' expression semi?
    ;

// EXTERN FN DECLARATION

externFnDeclaration
    : fnModifiers EXTERN FN name=identifier '(' typeList ')' (':' returnType=varType)? semi?
    ;

// STRUCT DECLARATION

structDeclaration
    : STRUCT identifier '{' structMember* '}' semi?
    ;

structMember
    : VAR_DECLARATION_TYPE identifier ':' varType semi?
    ;

// IMPORT DECLARATION

importDeclaration
    : IMPORT packageList semi?
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
    : declarationType=varDeclarationType name=identifier (':' type=varType)? '=' value=expression
    ;

returnStatement
    : RETURN expression
    ;

ifStatement
    : IF '(' expression ')' trueBlock=block (ELSE falseBlock=block)?
    ;

whileLoop
    : WHILE '(' expression ')' block
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
    : IF '(' test=expression ')' ifTrue=expression ELSE ifFalse=expression
    ;

literal
    : STRING
    | CHAR
    | INT
    | DOUBLE
    ;

// TYPES

varType
    : typeName=identifier
    | varType array='[]'
    | '(' args=typeList ')' '->' returnType=varType
    ;

// LISTS

expressionList
    : (expression ',')* expression?
    ;

identifierList
    : (identifier ',')* identifier?
    ;

typeList
    : (varType ',')* (vararg='...'|varType)?
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
    : VAR_DECLARATION_TYPE
    ;

semi
    : SEMICOLON+
    ;

// LEXER

DMOD: '%%';
STRING: '"' ('\\'.|.)*? '"';
CHAR: '\''.'\'';
INT: [0-9]+;
DOUBLE: [0-9]*'.'[0-9]+;
INLINE_C: DMOD .*? DMOD;

FN_MODIFIER: 'gpu'|'inline';
VAR_DECLARATION_TYPE: 'val'|'var';
RETURN: 'return';
FN: 'fn';
EXTERN: 'extern';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
STRUCT: 'struct';
SEMICOLON: ';';
IMPORT: 'import';

KEYWORD: FN_MODIFIER|VAR_DECLARATION_TYPE|RETURN|FN|EXTERN|IF|ELSE|WHILE|STRUCT|IMPORT;

IDENTIFIER: ([_a-zA-Z][_a-zA-Z0-9]*);

// WHITESPACE

BLOCK_COMMENT:'/*' .*? '*/'-> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
WHITESPACE:[ \r\n\t]+ -> skip;
