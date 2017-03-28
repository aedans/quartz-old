grammar Quartz;

// PARSER

program
    : declaration*
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
    | '=' expression
    ;

// EXTERN FN DECLARATION

externFnDeclaration
    : fnModifiers EXTERN_FN name=identifier '(' typeList ')' (':' returnType=varType)?
    ;

// STRUCT DECLARATION

structDeclaration
    : STRUCT identifier '{' structMember* '}'
    ;

structMember
    : VAR_DECLARATION_TYPE identifier ':' varType
    ;

// STATEMENTS

statement
    : inlineC
    | returnStatement SEMI
    | varDeclaration SEMI
    | ifStatement
    | whileLoop
    | expression SEMI
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

nameList
    : (identifier ',')* identifier?
    ;

typeList
    : (varType ',')* varType?
    ;

// UTIL

block
    : '{' statement* '}'
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
EXTERN_FN: 'extern_fn';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
STRUCT: 'struct';
SEMI: ';';

KEYWORD: FN_MODIFIER|VAR_DECLARATION_TYPE|RETURN|FN|EXTERN_FN|IF|ELSE|WHILE|STRUCT;

IDENTIFIER: ([_a-zA-Z][_a-zA-Z0-9]*);

// WHITESPACE

BLOCK_COMMENT:'/*' .*? '*/'-> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
WHITESPACE:[ \r\n\t]+ -> skip;
