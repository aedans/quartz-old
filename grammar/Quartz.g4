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
    : 'fn' NAME '(' fnArgumentList ')' (':' returnType=type)? block
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

// STRUCT DECLARATION

structDeclaration
    : extern='extern'? 'struct' NAME '{' structMember* '}' semi?
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
    : varDeclarationType nameOptionalType '=' expression
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
    : disjunction (assignmentOperation expression)?
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
    | '>='
    | '<='
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
    : '++'
    | '--'
    | '+'
    | '-'
    | '!'
    | '~'
    ;

postfixOperation
    : '++'
    | '--'
    | cast
    | postfixCall
    | memberAccess
    | dotCall
    ;

cast
    : 'as' type
    ;

postfixCall
    : '(' expressionList ')' lambda?
    | lambda
    ;

memberAccess
    : '.' NAME
    ;

dotCall
    : '.' identifier '(' expressionList ')' lambda?
    | lambda
    ;

lambda
    : 'fn' ('(' fnArgumentList ')')? (':' returnType=type)? block
    | ((fnArgumentList|nameList) '->')? '{' statementBlock '}'
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
    : NAME
    | '(' args=typeList ')' '->' returnType=type
    | ltype ptr='*'
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

statementBlock
    : statement*
    ;

// UTIL

block
    : '{' statementBlock '}' semi?
    | statement
    ;

identifier
    : NAME
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

nameOptionalType
    : NAME (':' type)?
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
