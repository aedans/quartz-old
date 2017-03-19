grammar Quartz;

// PARSER

program
    : declaration*
    ;

// DECLARATIONS

declaration
    : fnDeclaration
    | externFnDeclaration
    | inlineC
    ;

// FN DECLARATION

fnDeclaration
    : fnModifiers FN name=sIdentifier '(' fnArgumentList ')' (':' returnType=varType)? body=fnBlock
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
    : fnModifiers EXTERN_FN name=sIdentifier '(' typeList ')' (':' returnType=varType)?
    ;

// STATEMENTS

statement
    : inlineC
    | returnStatement
    | varDeclaration
    | ifStatement
    | whileLoop
    | prefixFnCall
    | infixFnCall
    | postfixFnCall
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
    : infixFnCall
    | atomicExpression
    ;

atomicExpression
    : identifier
    | literal
    | inlineC
    | ifExpression
    | '(' expression ')'
    | prefixFnCall
    | postfixFnCall
    ;

ifExpression
    : IF '(' expression ')' expression ELSE expression
    ;

prefixFnCall
    : name=sIdentifier '(' expressionList ')'
    ;

infixFnCall
    : expr1=atomicExpression '.' name=sIdentifier '(' expr2=expression ')'
    | expr1=atomicExpression name=sIdentifier expr2=expression
    ;

postfixFnCall
    : name=sIdentifier expression
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

sIdentifier
    : IDENTIFIER
    | SYMBOL
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

KEYWORD: FN_MODIFIER|VAR_DECLARATION_TYPE|RETURN|FN|EXTERN_FN|IF|ELSE|WHILE;

IDENTIFIER: [_a-zA-Z][_a-zA-Z0-9]*;
SYMBOL: ('+'|'-'|'*'|'/'|'!'|'|'|'&'|'='|'@'|'^'|'%'|'<'|'>')+;

// WHITESPACE

BLOCK_COMMENT:'/*' .*? '*/'-> skip;
LINE_COMMENT:'//' ~[\r\n]* -> skip;
WHITESPACE:[ \r\n\t]+ -> skip;
