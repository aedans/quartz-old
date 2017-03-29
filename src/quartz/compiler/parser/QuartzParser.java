// Generated from D:/win/OneDrive/jg/iCode/Quartz/grammar\Quartz.g4 by ANTLR 4.6
package quartz.compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuartzParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, DMOD=28, STRING=29, CHAR=30, INT=31, DOUBLE=32, 
		INLINE_C=33, FN_MODIFIER=34, VAR_DECLARATION_TYPE=35, RETURN=36, FN=37, 
		EXTERN=38, IF=39, ELSE=40, WHILE=41, STRUCT=42, SEMI=43, KEYWORD=44, IDENTIFIER=45, 
		BLOCK_COMMENT=46, LINE_COMMENT=47, WHITESPACE=48;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_fnDeclaration = 2, RULE_fnArgument = 3, 
		RULE_fnArgumentList = 4, RULE_fnModifiers = 5, RULE_fnBlock = 6, RULE_externFnDeclaration = 7, 
		RULE_structDeclaration = 8, RULE_structMember = 9, RULE_statement = 10, 
		RULE_varDeclaration = 11, RULE_returnStatement = 12, RULE_ifStatement = 13, 
		RULE_whileLoop = 14, RULE_expression = 15, RULE_disjunction = 16, RULE_conjunction = 17, 
		RULE_equalityComparison = 18, RULE_comparison = 19, RULE_additiveExpression = 20, 
		RULE_multiplicativeExpression = 21, RULE_prefixExpression = 22, RULE_postfixExpression = 23, 
		RULE_atomicExpression = 24, RULE_equalityOperation = 25, RULE_comparisonOperation = 26, 
		RULE_additiveOperation = 27, RULE_multiplicativeOperation = 28, RULE_prefixOperation = 29, 
		RULE_postfixOperation = 30, RULE_arrayAccess = 31, RULE_postfixCall = 32, 
		RULE_memberAccess = 33, RULE_ifExpression = 34, RULE_literal = 35, RULE_varType = 36, 
		RULE_expressionList = 37, RULE_identifierList = 38, RULE_typeList = 39, 
		RULE_block = 40, RULE_identifier = 41, RULE_inlineC = 42, RULE_varDeclarationType = 43;
	public static final String[] ruleNames = {
		"program", "declaration", "fnDeclaration", "fnArgument", "fnArgumentList", 
		"fnModifiers", "fnBlock", "externFnDeclaration", "structDeclaration", 
		"structMember", "statement", "varDeclaration", "returnStatement", "ifStatement", 
		"whileLoop", "expression", "disjunction", "conjunction", "equalityComparison", 
		"comparison", "additiveExpression", "multiplicativeExpression", "prefixExpression", 
		"postfixExpression", "atomicExpression", "equalityOperation", "comparisonOperation", 
		"additiveOperation", "multiplicativeOperation", "prefixOperation", "postfixOperation", 
		"arrayAccess", "postfixCall", "memberAccess", "ifExpression", "literal", 
		"varType", "expressionList", "identifierList", "typeList", "block", "identifier", 
		"inlineC", "varDeclarationType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "','", "'='", "'{'", "'}'", "'||'", "'&&'", 
		"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'!'", "'['", "']'", "'.'", "'[]'", "'->'", "'...'", "'%%'", null, 
		null, null, null, null, null, null, "'return'", "'fn'", "'extern'", "'if'", 
		"'else'", "'while'", "'struct'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", 
		"FN_MODIFIER", "VAR_DECLARATION_TYPE", "RETURN", "FN", "EXTERN", "IF", 
		"ELSE", "WHILE", "STRUCT", "SEMI", "KEYWORD", "IDENTIFIER", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Quartz.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuartzParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE_C) | (1L << FN_MODIFIER) | (1L << FN) | (1L << EXTERN) | (1L << STRUCT))) != 0)) {
				{
				{
				setState(88);
				declaration();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public FnDeclarationContext fnDeclaration() {
			return getRuleContext(FnDeclarationContext.class,0);
		}
		public ExternFnDeclarationContext externFnDeclaration() {
			return getRuleContext(ExternFnDeclarationContext.class,0);
		}
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public InlineCContext inlineC() {
			return getRuleContext(InlineCContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				fnDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				externFnDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				structDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				inlineC();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnDeclarationContext extends ParserRuleContext {
		public IdentifierContext name;
		public VarTypeContext returnType;
		public FnBlockContext body;
		public FnModifiersContext fnModifiers() {
			return getRuleContext(FnModifiersContext.class,0);
		}
		public TerminalNode FN() { return getToken(QuartzParser.FN, 0); }
		public FnArgumentListContext fnArgumentList() {
			return getRuleContext(FnArgumentListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public FnDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnDeclaration; }
	}

	public final FnDeclarationContext fnDeclaration() throws RecognitionException {
		FnDeclarationContext _localctx = new FnDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fnDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			fnModifiers();
			setState(101);
			match(FN);
			setState(102);
			((FnDeclarationContext)_localctx).name = identifier();
			setState(103);
			match(T__0);
			setState(104);
			fnArgumentList();
			setState(105);
			match(T__1);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(106);
				match(T__2);
				setState(107);
				((FnDeclarationContext)_localctx).returnType = varType(0);
				}
			}

			setState(110);
			((FnDeclarationContext)_localctx).body = fnBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnArgumentContext extends ParserRuleContext {
		public IdentifierContext name;
		public VarTypeContext type;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public FnArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnArgument; }
	}

	public final FnArgumentContext fnArgument() throws RecognitionException {
		FnArgumentContext _localctx = new FnArgumentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fnArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(112);
			((FnArgumentContext)_localctx).name = identifier();
			setState(113);
			match(T__2);
			setState(114);
			((FnArgumentContext)_localctx).type = varType(0);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnArgumentListContext extends ParserRuleContext {
		public List<FnArgumentContext> fnArgument() {
			return getRuleContexts(FnArgumentContext.class);
		}
		public FnArgumentContext fnArgument(int i) {
			return getRuleContext(FnArgumentContext.class,i);
		}
		public FnArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnArgumentList; }
	}

	public final FnArgumentListContext fnArgumentList() throws RecognitionException {
		FnArgumentListContext _localctx = new FnArgumentListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fnArgumentList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(116);
					fnArgument();
					setState(117);
					match(T__3);
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(124);
				fnArgument();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnModifiersContext extends ParserRuleContext {
		public List<TerminalNode> FN_MODIFIER() { return getTokens(QuartzParser.FN_MODIFIER); }
		public TerminalNode FN_MODIFIER(int i) {
			return getToken(QuartzParser.FN_MODIFIER, i);
		}
		public FnModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnModifiers; }
	}

	public final FnModifiersContext fnModifiers() throws RecognitionException {
		FnModifiersContext _localctx = new FnModifiersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fnModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FN_MODIFIER) {
				{
				{
				setState(127);
				match(FN_MODIFIER);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FnBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnBlock; }
	}

	public final FnBlockContext fnBlock() throws RecognitionException {
		FnBlockContext _localctx = new FnBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fnBlock);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__5:
			case T__16:
			case T__20:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case VAR_DECLARATION_TYPE:
			case RETURN:
			case IF:
			case WHILE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				block();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(T__4);
				setState(135);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternFnDeclarationContext extends ParserRuleContext {
		public IdentifierContext name;
		public VarTypeContext returnType;
		public FnModifiersContext fnModifiers() {
			return getRuleContext(FnModifiersContext.class,0);
		}
		public TerminalNode EXTERN() { return getToken(QuartzParser.EXTERN, 0); }
		public TerminalNode FN() { return getToken(QuartzParser.FN, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ExternFnDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externFnDeclaration; }
	}

	public final ExternFnDeclarationContext externFnDeclaration() throws RecognitionException {
		ExternFnDeclarationContext _localctx = new ExternFnDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_externFnDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			fnModifiers();
			setState(139);
			match(EXTERN);
			setState(140);
			match(FN);
			setState(141);
			((ExternFnDeclarationContext)_localctx).name = identifier();
			setState(142);
			match(T__0);
			setState(143);
			typeList();
			setState(144);
			match(T__1);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(145);
				match(T__2);
				setState(146);
				((ExternFnDeclarationContext)_localctx).returnType = varType(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(QuartzParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(STRUCT);
			setState(150);
			identifier();
			setState(151);
			match(T__5);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_DECLARATION_TYPE) {
				{
				{
				setState(152);
				structMember();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructMemberContext extends ParserRuleContext {
		public TerminalNode VAR_DECLARATION_TYPE() { return getToken(QuartzParser.VAR_DECLARATION_TYPE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_structMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(VAR_DECLARATION_TYPE);
			setState(161);
			identifier();
			setState(162);
			match(T__2);
			setState(163);
			varType(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public InlineCContext inlineC() {
			return getRuleContext(InlineCContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(QuartzParser.SEMI, 0); }
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				inlineC();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				returnStatement();
				setState(167);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				varDeclaration();
				setState(170);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				whileLoop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				expression();
				setState(175);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclarationTypeContext declarationType;
		public IdentifierContext name;
		public VarTypeContext type;
		public ExpressionContext value;
		public VarDeclarationTypeContext varDeclarationType() {
			return getRuleContext(VarDeclarationTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			((VarDeclarationContext)_localctx).declarationType = varDeclarationType();
			setState(180);
			((VarDeclarationContext)_localctx).name = identifier();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(181);
				match(T__2);
				setState(182);
				((VarDeclarationContext)_localctx).type = varType(0);
				}
			}

			setState(185);
			match(T__4);
			setState(186);
			((VarDeclarationContext)_localctx).value = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(QuartzParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(RETURN);
			setState(189);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public BlockContext trueBlock;
		public BlockContext falseBlock;
		public TerminalNode IF() { return getToken(QuartzParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(QuartzParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(IF);
			setState(192);
			match(T__0);
			setState(193);
			expression();
			setState(194);
			match(T__1);
			setState(195);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(196);
				match(ELSE);
				setState(197);
				((IfStatementContext)_localctx).falseBlock = block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(QuartzParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(WHILE);
			setState(201);
			match(T__0);
			setState(202);
			expression();
			setState(203);
			match(T__1);
			setState(204);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			disjunction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctionContext extends ParserRuleContext {
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			conjunction();
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(209);
				match(T__7);
				setState(210);
				disjunction();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctionContext extends ParserRuleContext {
		public EqualityComparisonContext equalityComparison() {
			return getRuleContext(EqualityComparisonContext.class,0);
		}
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			equalityComparison();
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(214);
				match(T__8);
				setState(215);
				conjunction();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityComparisonContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public EqualityOperationContext equalityOperation() {
			return getRuleContext(EqualityOperationContext.class,0);
		}
		public EqualityComparisonContext equalityComparison() {
			return getRuleContext(EqualityComparisonContext.class,0);
		}
		public EqualityComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityComparison; }
	}

	public final EqualityComparisonContext equalityComparison() throws RecognitionException {
		EqualityComparisonContext _localctx = new EqualityComparisonContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_equalityComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			comparison();
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(219);
				equalityOperation();
				setState(220);
				equalityComparison();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ComparisonOperationContext comparisonOperation() {
			return getRuleContext(ComparisonOperationContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			additiveExpression();
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(225);
				comparisonOperation();
				setState(226);
				comparison();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveOperationContext additiveOperation() {
			return getRuleContext(AdditiveOperationContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_additiveExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			multiplicativeExpression();
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(231);
				additiveOperation();
				setState(232);
				additiveExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public PrefixExpressionContext prefixExpression() {
			return getRuleContext(PrefixExpressionContext.class,0);
		}
		public MultiplicativeOperationContext multiplicativeOperation() {
			return getRuleContext(MultiplicativeOperationContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_multiplicativeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			prefixExpression();
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(237);
				multiplicativeOperation();
				setState(238);
				multiplicativeExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public List<PrefixOperationContext> prefixOperation() {
			return getRuleContexts(PrefixOperationContext.class);
		}
		public PrefixOperationContext prefixOperation(int i) {
			return getRuleContext(PrefixOperationContext.class,i);
		}
		public PrefixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExpression; }
	}

	public final PrefixExpressionContext prefixExpression() throws RecognitionException {
		PrefixExpressionContext _localctx = new PrefixExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_prefixExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16 || _la==T__20) {
				{
				{
				setState(242);
				prefixOperation();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			postfixExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends ParserRuleContext {
		public AtomicExpressionContext atomicExpression() {
			return getRuleContext(AtomicExpressionContext.class,0);
		}
		public List<PostfixOperationContext> postfixOperation() {
			return getRuleContexts(PostfixOperationContext.class);
		}
		public PostfixOperationContext postfixOperation(int i) {
			return getRuleContext(PostfixOperationContext.class,i);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			atomicExpression();
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					postfixOperation();
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InlineCContext inlineC() {
			return getRuleContext(InlineCContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public AtomicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicExpression; }
	}

	public final AtomicExpressionContext atomicExpression() throws RecognitionException {
		AtomicExpressionContext _localctx = new AtomicExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_atomicExpression);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				match(T__0);
				setState(258);
				expression();
				setState(259);
				match(T__1);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				ifExpression();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				identifier();
				}
				break;
			case INLINE_C:
				enterOuterAlt(_localctx, 4);
				{
				setState(263);
				inlineC();
				}
				break;
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(264);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityOperationContext extends ParserRuleContext {
		public EqualityOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOperation; }
	}

	public final EqualityOperationContext equalityOperation() throws RecognitionException {
		EqualityOperationContext _localctx = new EqualityOperationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperationContext extends ParserRuleContext {
		public ComparisonOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperation; }
	}

	public final ComparisonOperationContext comparisonOperation() throws RecognitionException {
		ComparisonOperationContext _localctx = new ComparisonOperationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_comparisonOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveOperationContext extends ParserRuleContext {
		public AdditiveOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOperation; }
	}

	public final AdditiveOperationContext additiveOperation() throws RecognitionException {
		AdditiveOperationContext _localctx = new AdditiveOperationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_additiveOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeOperationContext extends ParserRuleContext {
		public MultiplicativeOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeOperation; }
	}

	public final MultiplicativeOperationContext multiplicativeOperation() throws RecognitionException {
		MultiplicativeOperationContext _localctx = new MultiplicativeOperationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixOperationContext extends ParserRuleContext {
		public PrefixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOperation; }
	}

	public final PrefixOperationContext prefixOperation() throws RecognitionException {
		PrefixOperationContext _localctx = new PrefixOperationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_prefixOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__20) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixOperationContext extends ParserRuleContext {
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public PostfixCallContext postfixCall() {
			return getRuleContext(PostfixCallContext.class,0);
		}
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public PostfixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOperation; }
	}

	public final PostfixOperationContext postfixOperation() throws RecognitionException {
		PostfixOperationContext _localctx = new PostfixOperationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_postfixOperation);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				arrayAccess();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				postfixCall();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(279);
				memberAccess();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccessContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__21);
			setState(283);
			expression();
			setState(284);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixCallContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public PostfixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixCall; }
	}

	public final PostfixCallContext postfixCall() throws RecognitionException {
		PostfixCallContext _localctx = new PostfixCallContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_postfixCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__0);
			setState(287);
			expressionList();
			setState(288);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberAccessContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(T__23);
			setState(291);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfExpressionContext extends ParserRuleContext {
		public ExpressionContext test;
		public ExpressionContext ifTrue;
		public ExpressionContext ifFalse;
		public TerminalNode IF() { return getToken(QuartzParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(QuartzParser.ELSE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpression; }
	}

	public final IfExpressionContext ifExpression() throws RecognitionException {
		IfExpressionContext _localctx = new IfExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(IF);
			setState(294);
			match(T__0);
			setState(295);
			((IfExpressionContext)_localctx).test = expression();
			setState(296);
			match(T__1);
			setState(297);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(298);
			match(ELSE);
			setState(299);
			((IfExpressionContext)_localctx).ifFalse = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QuartzParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(QuartzParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(QuartzParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(QuartzParser.DOUBLE, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public IdentifierContext typeName;
		public TypeListContext args;
		public VarTypeContext returnType;
		public Token array;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	}

	public final VarTypeContext varType() throws RecognitionException {
		return varType(0);
	}

	private VarTypeContext varType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarTypeContext _localctx = new VarTypeContext(_ctx, _parentState);
		VarTypeContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_varType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(304);
				((VarTypeContext)_localctx).typeName = identifier();
				}
				break;
			case T__0:
				{
				setState(305);
				match(T__0);
				setState(306);
				((VarTypeContext)_localctx).args = typeList();
				setState(307);
				match(T__1);
				setState(308);
				match(T__25);
				setState(309);
				((VarTypeContext)_localctx).returnType = varType(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varType);
					setState(313);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(314);
					((VarTypeContext)_localctx).array = match(T__24);
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(320);
					expression();
					setState(321);
					match(T__3);
					}
					} 
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__20) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IF) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(328);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_identifierList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(331);
					identifier();
					setState(332);
					match(T__3);
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(339);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeListContext extends ParserRuleContext {
		public Token vararg;
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_typeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(342);
					varType(0);
					setState(343);
					match(T__3);
					}
					} 
				}
				setState(349);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(350);
				((TypeListContext)_localctx).vararg = match(T__26);
				}
				break;
			case T__0:
			case IDENTIFIER:
				{
				setState(351);
				varType(0);
				}
				break;
			case T__1:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_block);
		int _la;
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(T__5);
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__20) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << VAR_DECLARATION_TYPE) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(355);
					statement();
					}
					}
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(361);
				match(T__6);
				}
				break;
			case T__0:
			case T__16:
			case T__20:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case VAR_DECLARATION_TYPE:
			case RETURN:
			case IF:
			case WHILE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(QuartzParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineCContext extends ParserRuleContext {
		public TerminalNode INLINE_C() { return getToken(QuartzParser.INLINE_C, 0); }
		public InlineCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineC; }
	}

	public final InlineCContext inlineC() throws RecognitionException {
		InlineCContext _localctx = new InlineCContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_inlineC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(INLINE_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationTypeContext extends ParserRuleContext {
		public TerminalNode VAR_DECLARATION_TYPE() { return getToken(QuartzParser.VAR_DECLARATION_TYPE, 0); }
		public VarDeclarationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclarationType; }
	}

	public final VarDeclarationTypeContext varDeclarationType() throws RecognitionException {
		VarDeclarationTypeContext _localctx = new VarDeclarationTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_varDeclarationType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(VAR_DECLARATION_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 36:
			return varType_sempred((VarTypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean varType_sempred(VarTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0176\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\7\2\\\n\2\f\2\16\2_\13\2\3\3\3\3\3\3\3\3\5\3e\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\7\6z\n\6\f\6\16\6}\13\6\3\6\5\6\u0080\n\6\3\7\7\7\u0083\n\7\f\7\16"+
		"\7\u0086\13\7\3\b\3\b\3\b\5\b\u008b\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t\u0096\n\t\3\n\3\n\3\n\3\n\7\n\u009c\n\n\f\n\16\n\u009f\13\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00b4\n\f\3\r\3\r\3\r\3\r\5\r\u00ba\n\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c9\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\5\22\u00d6\n\22\3\23"+
		"\3\23\3\23\5\23\u00db\n\23\3\24\3\24\3\24\3\24\5\24\u00e1\n\24\3\25\3"+
		"\25\3\25\3\25\5\25\u00e7\n\25\3\26\3\26\3\26\3\26\5\26\u00ed\n\26\3\27"+
		"\3\27\3\27\3\27\5\27\u00f3\n\27\3\30\7\30\u00f6\n\30\f\30\16\30\u00f9"+
		"\13\30\3\30\3\30\3\31\3\31\7\31\u00ff\n\31\f\31\16\31\u0102\13\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u010c\n\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \5 \u011b\n \3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\5&\u013a\n&\3&\3&\7&\u013e\n&\f&\16&\u0141\13&\3\'\3\'\3\'\7\'\u0146"+
		"\n\'\f\'\16\'\u0149\13\'\3\'\5\'\u014c\n\'\3(\3(\3(\7(\u0151\n(\f(\16"+
		"(\u0154\13(\3(\5(\u0157\n(\3)\3)\3)\7)\u015c\n)\f)\16)\u015f\13)\3)\3"+
		")\5)\u0163\n)\3*\3*\7*\u0167\n*\f*\16*\u016a\13*\3*\3*\5*\u016e\n*\3+"+
		"\3+\3,\3,\3-\3-\3-\2\3J.\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\b\3\2\f\r\3\2\16\21\3\2\22\23\3\2\24"+
		"\26\4\2\23\23\27\27\3\2\37\"\u0174\2]\3\2\2\2\4d\3\2\2\2\6f\3\2\2\2\b"+
		"r\3\2\2\2\n{\3\2\2\2\f\u0084\3\2\2\2\16\u008a\3\2\2\2\20\u008c\3\2\2\2"+
		"\22\u0097\3\2\2\2\24\u00a2\3\2\2\2\26\u00b3\3\2\2\2\30\u00b5\3\2\2\2\32"+
		"\u00be\3\2\2\2\34\u00c1\3\2\2\2\36\u00ca\3\2\2\2 \u00d0\3\2\2\2\"\u00d2"+
		"\3\2\2\2$\u00d7\3\2\2\2&\u00dc\3\2\2\2(\u00e2\3\2\2\2*\u00e8\3\2\2\2,"+
		"\u00ee\3\2\2\2.\u00f7\3\2\2\2\60\u00fc\3\2\2\2\62\u010b\3\2\2\2\64\u010d"+
		"\3\2\2\2\66\u010f\3\2\2\28\u0111\3\2\2\2:\u0113\3\2\2\2<\u0115\3\2\2\2"+
		">\u011a\3\2\2\2@\u011c\3\2\2\2B\u0120\3\2\2\2D\u0124\3\2\2\2F\u0127\3"+
		"\2\2\2H\u012f\3\2\2\2J\u0139\3\2\2\2L\u0147\3\2\2\2N\u0152\3\2\2\2P\u015d"+
		"\3\2\2\2R\u016d\3\2\2\2T\u016f\3\2\2\2V\u0171\3\2\2\2X\u0173\3\2\2\2Z"+
		"\\\5\4\3\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\3\3\2\2\2_]\3\2\2"+
		"\2`e\5\6\4\2ae\5\20\t\2be\5\22\n\2ce\5V,\2d`\3\2\2\2da\3\2\2\2db\3\2\2"+
		"\2dc\3\2\2\2e\5\3\2\2\2fg\5\f\7\2gh\7\'\2\2hi\5T+\2ij\7\3\2\2jk\5\n\6"+
		"\2kn\7\4\2\2lm\7\5\2\2mo\5J&\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\5\16\b"+
		"\2q\7\3\2\2\2rs\5T+\2st\7\5\2\2tu\5J&\2u\t\3\2\2\2vw\5\b\5\2wx\7\6\2\2"+
		"xz\3\2\2\2yv\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2"+
		"\2\2~\u0080\5\b\5\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\13\3\2\2\2\u0081"+
		"\u0083\7$\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\r\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u008b"+
		"\5R*\2\u0088\u0089\7\7\2\2\u0089\u008b\5 \21\2\u008a\u0087\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\17\3\2\2\2\u008c\u008d\5\f\7\2\u008d\u008e\7(\2\2"+
		"\u008e\u008f\7\'\2\2\u008f\u0090\5T+\2\u0090\u0091\7\3\2\2\u0091\u0092"+
		"\5P)\2\u0092\u0095\7\4\2\2\u0093\u0094\7\5\2\2\u0094\u0096\5J&\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\21\3\2\2\2\u0097\u0098\7,\2\2"+
		"\u0098\u0099\5T+\2\u0099\u009d\7\b\2\2\u009a\u009c\5\24\13\2\u009b\u009a"+
		"\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\t\2\2\u00a1\23\3\2\2"+
		"\2\u00a2\u00a3\7%\2\2\u00a3\u00a4\5T+\2\u00a4\u00a5\7\5\2\2\u00a5\u00a6"+
		"\5J&\2\u00a6\25\3\2\2\2\u00a7\u00b4\5V,\2\u00a8\u00a9\5\32\16\2\u00a9"+
		"\u00aa\7-\2\2\u00aa\u00b4\3\2\2\2\u00ab\u00ac\5\30\r\2\u00ac\u00ad\7-"+
		"\2\2\u00ad\u00b4\3\2\2\2\u00ae\u00b4\5\34\17\2\u00af\u00b4\5\36\20\2\u00b0"+
		"\u00b1\5 \21\2\u00b1\u00b2\7-\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00a7\3\2"+
		"\2\2\u00b3\u00a8\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b3"+
		"\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4\27\3\2\2\2\u00b5\u00b6\5X-\2"+
		"\u00b6\u00b9\5T+\2\u00b7\u00b8\7\5\2\2\u00b8\u00ba\5J&\2\u00b9\u00b7\3"+
		"\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\7\2\2\u00bc"+
		"\u00bd\5 \21\2\u00bd\31\3\2\2\2\u00be\u00bf\7&\2\2\u00bf\u00c0\5 \21\2"+
		"\u00c0\33\3\2\2\2\u00c1\u00c2\7)\2\2\u00c2\u00c3\7\3\2\2\u00c3\u00c4\5"+
		" \21\2\u00c4\u00c5\7\4\2\2\u00c5\u00c8\5R*\2\u00c6\u00c7\7*\2\2\u00c7"+
		"\u00c9\5R*\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\35\3\2\2\2"+
		"\u00ca\u00cb\7+\2\2\u00cb\u00cc\7\3\2\2\u00cc\u00cd\5 \21\2\u00cd\u00ce"+
		"\7\4\2\2\u00ce\u00cf\5R*\2\u00cf\37\3\2\2\2\u00d0\u00d1\5\"\22\2\u00d1"+
		"!\3\2\2\2\u00d2\u00d5\5$\23\2\u00d3\u00d4\7\n\2\2\u00d4\u00d6\5\"\22\2"+
		"\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6#\3\2\2\2\u00d7\u00da\5"+
		"&\24\2\u00d8\u00d9\7\13\2\2\u00d9\u00db\5$\23\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db%\3\2\2\2\u00dc\u00e0\5(\25\2\u00dd\u00de\5\64\33"+
		"\2\u00de\u00df\5&\24\2\u00df\u00e1\3\2\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\'\3\2\2\2\u00e2\u00e6\5*\26\2\u00e3\u00e4\5\66\34\2\u00e4"+
		"\u00e5\5(\25\2\u00e5\u00e7\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7)\3\2\2\2\u00e8\u00ec\5,\27\2\u00e9\u00ea\58\35\2\u00ea\u00eb"+
		"\5*\26\2\u00eb\u00ed\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"+\3\2\2\2\u00ee\u00f2\5.\30\2\u00ef\u00f0\5:\36\2\u00f0\u00f1\5,\27\2"+
		"\u00f1\u00f3\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3-\3"+
		"\2\2\2\u00f4\u00f6\5<\37\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\u00fb\5\60\31\2\u00fb/\3\2\2\2\u00fc\u0100\5\62\32\2\u00fd"+
		"\u00ff\5> \2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2"+
		"\2\u0100\u0101\3\2\2\2\u0101\61\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104"+
		"\7\3\2\2\u0104\u0105\5 \21\2\u0105\u0106\7\4\2\2\u0106\u010c\3\2\2\2\u0107"+
		"\u010c\5F$\2\u0108\u010c\5T+\2\u0109\u010c\5V,\2\u010a\u010c\5H%\2\u010b"+
		"\u0103\3\2\2\2\u010b\u0107\3\2\2\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010a\3\2\2\2\u010c\63\3\2\2\2\u010d\u010e\t\2\2\2\u010e\65"+
		"\3\2\2\2\u010f\u0110\t\3\2\2\u0110\67\3\2\2\2\u0111\u0112\t\4\2\2\u0112"+
		"9\3\2\2\2\u0113\u0114\t\5\2\2\u0114;\3\2\2\2\u0115\u0116\t\6\2\2\u0116"+
		"=\3\2\2\2\u0117\u011b\5@!\2\u0118\u011b\5B\"\2\u0119\u011b\5D#\2\u011a"+
		"\u0117\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b?\3\2\2\2"+
		"\u011c\u011d\7\30\2\2\u011d\u011e\5 \21\2\u011e\u011f\7\31\2\2\u011fA"+
		"\3\2\2\2\u0120\u0121\7\3\2\2\u0121\u0122\5L\'\2\u0122\u0123\7\4\2\2\u0123"+
		"C\3\2\2\2\u0124\u0125\7\32\2\2\u0125\u0126\5T+\2\u0126E\3\2\2\2\u0127"+
		"\u0128\7)\2\2\u0128\u0129\7\3\2\2\u0129\u012a\5 \21\2\u012a\u012b\7\4"+
		"\2\2\u012b\u012c\5 \21\2\u012c\u012d\7*\2\2\u012d\u012e\5 \21\2\u012e"+
		"G\3\2\2\2\u012f\u0130\t\7\2\2\u0130I\3\2\2\2\u0131\u0132\b&\1\2\u0132"+
		"\u013a\5T+\2\u0133\u0134\7\3\2\2\u0134\u0135\5P)\2\u0135\u0136\7\4\2\2"+
		"\u0136\u0137\7\34\2\2\u0137\u0138\5J&\3\u0138\u013a\3\2\2\2\u0139\u0131"+
		"\3\2\2\2\u0139\u0133\3\2\2\2\u013a\u013f\3\2\2\2\u013b\u013c\f\4\2\2\u013c"+
		"\u013e\7\33\2\2\u013d\u013b\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3"+
		"\2\2\2\u013f\u0140\3\2\2\2\u0140K\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143"+
		"\5 \21\2\u0143\u0144\7\6\2\2\u0144\u0146\3\2\2\2\u0145\u0142\3\2\2\2\u0146"+
		"\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014b\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u014a\u014c\5 \21\2\u014b\u014a\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014cM\3\2\2\2\u014d\u014e\5T+\2\u014e\u014f\7\6\2\2\u014f"+
		"\u0151\3\2\2\2\u0150\u014d\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0155"+
		"\u0157\5T+\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157O\3\2\2\2\u0158"+
		"\u0159\5J&\2\u0159\u015a\7\6\2\2\u015a\u015c\3\2\2\2\u015b\u0158\3\2\2"+
		"\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0162"+
		"\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0163\7\35\2\2\u0161\u0163\5J&\2\u0162"+
		"\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163Q\3\2\2\2"+
		"\u0164\u0168\7\b\2\2\u0165\u0167\5\26\f\2\u0166\u0165\3\2\2\2\u0167\u016a"+
		"\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016b\u016e\7\t\2\2\u016c\u016e\5\26\f\2\u016d\u0164\3"+
		"\2\2\2\u016d\u016c\3\2\2\2\u016eS\3\2\2\2\u016f\u0170\7/\2\2\u0170U\3"+
		"\2\2\2\u0171\u0172\7#\2\2\u0172W\3\2\2\2\u0173\u0174\7%\2\2\u0174Y\3\2"+
		"\2\2\"]dn{\177\u0084\u008a\u0095\u009d\u00b3\u00b9\u00c8\u00d5\u00da\u00e0"+
		"\u00e6\u00ec\u00f2\u00f7\u0100\u010b\u011a\u0139\u013f\u0147\u014b\u0152"+
		"\u0156\u015d\u0162\u0168\u016d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}