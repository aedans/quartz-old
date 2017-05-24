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
    : 'import' packageList ';'?
    ;

packageList
    : (NAME '.')* NAME
    ;

// EXPRESSIONS

expression
    : varDeclaration
    | returnExpression
    | ifExpression
    | whileExpression
    | assignmentExpression
    ;

varDeclaration
    : varDeclarationType NAME (':' type)? '=' expression
    ;

returnExpression
    : 'return' expression
    ;

ifExpression
    : 'if' '(' test=expression ')' ifTrue=block ('else' ifFalse=block)?
    ;

whileExpression
    : 'while' '(' test=expression ')' block
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
    | breakExpression
    | continueExpression
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

lambda
    : 'lambda' ('(' fnArgumentList ')')? (':' returnType=type)? atomicBlock
    | ((fnArgumentList|nameList) '->') atomicBlock
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
    : isConst='const'? unqualifiedType
    ;

unqualifiedType
    : NAME
    | INLINE_C
    | functionType
    | unqualifiedType ptr='*'
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
    : '{' (expression ';'?)* '}'
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
