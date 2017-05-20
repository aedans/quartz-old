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
    : 'fn' NAME ('<' genericArgumentList '>')? '(' fnArgumentList ')' (':' returnType=type)? eBlock
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

genericArgument
    : NAME
    ;

genericArgumentList
    : (genericArgument ',')* genericArgument?
    ;

// STRUCT DECLARATION

structDeclaration
    : extern='extern'? 'struct' NAME '{' structMember* '}' semi?
    ;

structMember
    : NAME ':' type semi?
    ;

// TYPEALIAS DECLARATION

typealiasDeclaration
    : 'typealias' NAME '=' type semi?
    ;

// IMPORT DECLARATION

importDeclaration
    : 'import' packageList semi?
    ;

packageList
    : (NAME '.')* NAME
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
    | inlineC
    | literal
    | sizeof
    | breakExpression
    | continueExpression
    | returnExpression
    | ifExpression
    | whileExpression
    | varDeclaration
    | lambda
    | identifier
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

breakExpression
    : 'break'
    ;

continueExpression
    : 'continue'
    ;

returnExpression
    : 'return' expression
    ;

ifExpression
    : 'if' '(' test=expression ')' ifTrue=sBlock ('else' ifFalse=block)?
    ;

whileExpression
    : 'while' '(' test=expression ')' loop=block
    ;

varDeclaration
    : varDeclarationType nameOptionalType ('=' expression)?
    ;

lambda
    : 'lambda' ('(' fnArgumentList ')')? (':' returnType=type)? eBlock
    | ((fnArgumentList|nameList) '->')? eBlock
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

// TYPES

type
    : isConst='const'? ltype
    ;

ltype
    : NAME
    | INLINE_C
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

// UTIL

block
    : '{' (expression semi?)* expression? semi? '}' semi?
    | expression
    ;

sBlock
    : '{' (expression semi?)* expression? semi? '}'
    | expression semi?
    ;

eBlock
    : '{' (expression semi?)* expression? semi? '}' semi?
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
    : ';'
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
