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
		T__24=25, DMOD=26, STRING=27, CHAR=28, INT=29, DOUBLE=30, INLINE_C=31, 
		FN_MODIFIER=32, VAR_DECLARATION_TYPE=33, RETURN=34, FN=35, EXTERN_FN=36, 
		IF=37, ELSE=38, WHILE=39, KEYWORD=40, IDENTIFIER=41, BLOCK_COMMENT=42, 
		LINE_COMMENT=43, WHITESPACE=44;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_fnDeclaration = 2, RULE_fnArgument = 3, 
		RULE_fnArgumentList = 4, RULE_fnModifiers = 5, RULE_fnBlock = 6, RULE_externFnDeclaration = 7, 
		RULE_statement = 8, RULE_varDeclaration = 9, RULE_returnStatement = 10, 
		RULE_ifStatement = 11, RULE_whileLoop = 12, RULE_expression = 13, RULE_disjunction = 14, 
		RULE_conjunction = 15, RULE_equalityComparison = 16, RULE_comparison = 17, 
		RULE_additiveExpression = 18, RULE_multiplicativeExpression = 19, RULE_prefixExpression = 20, 
		RULE_postfixExpression = 21, RULE_atomicExpression = 22, RULE_equalityOperation = 23, 
		RULE_comparisonOperation = 24, RULE_additiveOperation = 25, RULE_multiplicativeOperation = 26, 
		RULE_prefixOperation = 27, RULE_postfixOperation = 28, RULE_arrayAccess = 29, 
		RULE_infixCall = 30, RULE_prefixCallExpression = 31, RULE_infixCallExpression = 32, 
		RULE_ifExpression = 33, RULE_literal = 34, RULE_varType = 35, RULE_expressionList = 36, 
		RULE_nameList = 37, RULE_typeList = 38, RULE_block = 39, RULE_identifier = 40, 
		RULE_inlineC = 41, RULE_varDeclarationType = 42;
	public static final String[] ruleNames = {
		"program", "declaration", "fnDeclaration", "fnArgument", "fnArgumentList", 
		"fnModifiers", "fnBlock", "externFnDeclaration", "statement", "varDeclaration", 
		"returnStatement", "ifStatement", "whileLoop", "expression", "disjunction", 
		"conjunction", "equalityComparison", "comparison", "additiveExpression", 
		"multiplicativeExpression", "prefixExpression", "postfixExpression", "atomicExpression", 
		"equalityOperation", "comparisonOperation", "additiveOperation", "multiplicativeOperation", 
		"prefixOperation", "postfixOperation", "arrayAccess", "infixCall", "prefixCallExpression", 
		"infixCallExpression", "ifExpression", "literal", "varType", "expressionList", 
		"nameList", "typeList", "block", "identifier", "inlineC", "varDeclarationType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "','", "'='", "'||'", "'&&'", "'=='", "'!='", 
		"'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", 
		"'['", "']'", "'.'", "'[]'", "'{'", "'}'", "'%%'", null, null, null, null, 
		null, null, null, "'return'", "'fn'", "'extern_fn'", "'if'", "'else'", 
		"'while'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", "FN_MODIFIER", 
		"VAR_DECLARATION_TYPE", "RETURN", "FN", "EXTERN_FN", "IF", "ELSE", "WHILE", 
		"KEYWORD", "IDENTIFIER", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
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
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INLINE_C) | (1L << FN_MODIFIER) | (1L << FN) | (1L << EXTERN_FN))) != 0)) {
				{
				{
				setState(86);
				declaration();
				}
				}
				setState(91);
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				fnDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				externFnDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
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
			setState(97);
			fnModifiers();
			setState(98);
			match(FN);
			setState(99);
			((FnDeclarationContext)_localctx).name = identifier();
			setState(100);
			match(T__0);
			setState(101);
			fnArgumentList();
			setState(102);
			match(T__1);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(103);
				match(T__2);
				setState(104);
				((FnDeclarationContext)_localctx).returnType = varType(0);
				}
			}

			setState(107);
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
			setState(109);
			((FnArgumentContext)_localctx).name = identifier();
			setState(110);
			match(T__2);
			setState(111);
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
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113);
					fnArgument();
					setState(114);
					match(T__3);
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(121);
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
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FN_MODIFIER) {
				{
				{
				setState(124);
				match(FN_MODIFIER);
				}
				}
				setState(129);
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
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__14:
			case T__18:
			case T__23:
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
				setState(130);
				block();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__4);
				setState(132);
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
		public TerminalNode EXTERN_FN() { return getToken(QuartzParser.EXTERN_FN, 0); }
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
			setState(135);
			fnModifiers();
			setState(136);
			match(EXTERN_FN);
			setState(137);
			((ExternFnDeclarationContext)_localctx).name = identifier();
			setState(138);
			match(T__0);
			setState(139);
			typeList();
			setState(140);
			match(T__1);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(141);
				match(T__2);
				setState(142);
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

	public static class StatementContext extends ParserRuleContext {
		public InlineCContext inlineC() {
			return getRuleContext(InlineCContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public PrefixCallExpressionContext prefixCallExpression() {
			return getRuleContext(PrefixCallExpressionContext.class,0);
		}
		public InfixCallExpressionContext infixCallExpression() {
			return getRuleContext(InfixCallExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				inlineC();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				returnStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				varDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				whileLoop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				prefixCallExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
				infixCallExpression();
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
		enterRule(_localctx, 18, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			((VarDeclarationContext)_localctx).declarationType = varDeclarationType();
			setState(155);
			((VarDeclarationContext)_localctx).name = identifier();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(156);
				match(T__2);
				setState(157);
				((VarDeclarationContext)_localctx).type = varType(0);
				}
			}

			setState(160);
			match(T__4);
			setState(161);
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
		enterRule(_localctx, 20, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(RETURN);
			setState(164);
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
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(IF);
			setState(167);
			match(T__0);
			setState(168);
			expression();
			setState(169);
			match(T__1);
			setState(170);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(171);
				match(ELSE);
				setState(172);
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
		enterRule(_localctx, 24, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(WHILE);
			setState(176);
			match(T__0);
			setState(177);
			expression();
			setState(178);
			match(T__1);
			setState(179);
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
		enterRule(_localctx, 26, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
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
		enterRule(_localctx, 28, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			conjunction();
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(184);
				match(T__5);
				setState(185);
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
		enterRule(_localctx, 30, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			equalityComparison();
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(189);
				match(T__6);
				setState(190);
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
		enterRule(_localctx, 32, RULE_equalityComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			comparison();
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(194);
				equalityOperation();
				setState(195);
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
		enterRule(_localctx, 34, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			additiveExpression();
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(200);
				comparisonOperation();
				setState(201);
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
		enterRule(_localctx, 36, RULE_additiveExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			multiplicativeExpression();
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(206);
				additiveOperation();
				setState(207);
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
		enterRule(_localctx, 38, RULE_multiplicativeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			prefixExpression();
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(212);
				multiplicativeOperation();
				setState(213);
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
		enterRule(_localctx, 40, RULE_prefixExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14 || _la==T__18) {
				{
				{
				setState(217);
				prefixOperation();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
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
		enterRule(_localctx, 42, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			atomicExpression();
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(226);
					postfixOperation();
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public PrefixCallExpressionContext prefixCallExpression() {
			return getRuleContext(PrefixCallExpressionContext.class,0);
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
		enterRule(_localctx, 44, RULE_atomicExpression);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(T__0);
				setState(233);
				expression();
				setState(234);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				prefixCallExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				ifExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				identifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				inlineC();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				literal();
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

	public static class EqualityOperationContext extends ParserRuleContext {
		public EqualityOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOperation; }
	}

	public final EqualityOperationContext equalityOperation() throws RecognitionException {
		EqualityOperationContext _localctx = new EqualityOperationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
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
		enterRule(_localctx, 48, RULE_comparisonOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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
		enterRule(_localctx, 50, RULE_additiveOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
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
		enterRule(_localctx, 52, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
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
		enterRule(_localctx, 54, RULE_prefixOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__18) ) {
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
		public InfixCallContext infixCall() {
			return getRuleContext(InfixCallContext.class,0);
		}
		public PostfixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOperation; }
	}

	public final PostfixOperationContext postfixOperation() throws RecognitionException {
		PostfixOperationContext _localctx = new PostfixOperationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_postfixOperation);
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				arrayAccess();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				infixCall();
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
		enterRule(_localctx, 58, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__19);
			setState(258);
			expression();
			setState(259);
			match(T__20);
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

	public static class InfixCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public InfixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixCall; }
	}

	public final InfixCallContext infixCall() throws RecognitionException {
		InfixCallContext _localctx = new InfixCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_infixCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__21);
			setState(262);
			identifier();
			setState(263);
			match(T__0);
			setState(264);
			expressionList();
			setState(265);
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

	public static class PrefixCallExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public PrefixCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixCallExpression; }
	}

	public final PrefixCallExpressionContext prefixCallExpression() throws RecognitionException {
		PrefixCallExpressionContext _localctx = new PrefixCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_prefixCallExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			identifier();
			setState(268);
			match(T__0);
			setState(269);
			expressionList();
			setState(270);
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

	public static class InfixCallExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InfixCallContext infixCall() {
			return getRuleContext(InfixCallContext.class,0);
		}
		public InfixCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixCallExpression; }
	}

	public final InfixCallExpressionContext infixCallExpression() throws RecognitionException {
		InfixCallExpressionContext _localctx = new InfixCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_infixCallExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			expression();
			setState(273);
			infixCall();
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
		enterRule(_localctx, 66, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(IF);
			setState(276);
			match(T__0);
			setState(277);
			((IfExpressionContext)_localctx).test = expression();
			setState(278);
			match(T__1);
			setState(279);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(280);
			match(ELSE);
			setState(281);
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
		enterRule(_localctx, 68, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
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
		public Token array;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_varType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(286);
			((VarTypeContext)_localctx).typeName = identifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varType);
					setState(288);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(289);
					((VarTypeContext)_localctx).array = match(T__22);
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 72, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(295);
					expression();
					setState(296);
					match(T__3);
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__18) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IF) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(303);
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

	public static class NameListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public NameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameList; }
	}

	public final NameListContext nameList() throws RecognitionException {
		NameListContext _localctx = new NameListContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_nameList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(306);
					identifier();
					setState(307);
					match(T__3);
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(314);
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
		enterRule(_localctx, 76, RULE_typeList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(317);
					varType(0);
					setState(318);
					match(T__3);
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(325);
				varType(0);
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
		enterRule(_localctx, 78, RULE_block);
		int _la;
		try {
			setState(337);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				match(T__23);
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__18) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << VAR_DECLARATION_TYPE) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(329);
					statement();
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(335);
				match(T__24);
				}
				break;
			case T__0:
			case T__14:
			case T__18:
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
				setState(336);
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
		enterRule(_localctx, 80, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
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
		enterRule(_localctx, 82, RULE_inlineC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
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
		enterRule(_localctx, 84, RULE_varDeclarationType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
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
		case 35:
			return varType_sempred((VarTypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean varType_sempred(VarTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u015c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\3\3\3\3\3\5\3b\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4l\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6w\n\6"+
		"\f\6\16\6z\13\6\3\6\5\6}\n\6\3\7\7\7\u0080\n\7\f\7\16\7\u0083\13\7\3\b"+
		"\3\b\3\b\5\b\u0088\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0092\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009b\n\n\3\13\3\13\3\13\3\13\5\13\u00a1"+
		"\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b0"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\5\20\u00bd"+
		"\n\20\3\21\3\21\3\21\5\21\u00c2\n\21\3\22\3\22\3\22\3\22\5\22\u00c8\n"+
		"\22\3\23\3\23\3\23\3\23\5\23\u00ce\n\23\3\24\3\24\3\24\3\24\5\24\u00d4"+
		"\n\24\3\25\3\25\3\25\3\25\5\25\u00da\n\25\3\26\7\26\u00dd\n\26\f\26\16"+
		"\26\u00e0\13\26\3\26\3\26\3\27\3\27\7\27\u00e6\n\27\f\27\16\27\u00e9\13"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00f4\n\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\5\36\u0102\n\36"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3$\3$\3%\3%\3%\3%\3%\7%\u0125\n%\f%\16%\u0128\13%"+
		"\3&\3&\3&\7&\u012d\n&\f&\16&\u0130\13&\3&\5&\u0133\n&\3\'\3\'\3\'\7\'"+
		"\u0138\n\'\f\'\16\'\u013b\13\'\3\'\5\'\u013e\n\'\3(\3(\3(\7(\u0143\n("+
		"\f(\16(\u0146\13(\3(\5(\u0149\n(\3)\3)\7)\u014d\n)\f)\16)\u0150\13)\3"+
		")\3)\5)\u0154\n)\3*\3*\3+\3+\3,\3,\3,\2\3H-\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\b\3\2\n\13\3\2\f\17"+
		"\3\2\20\21\3\2\22\24\4\2\21\21\25\25\3\2\35 \u0158\2[\3\2\2\2\4a\3\2\2"+
		"\2\6c\3\2\2\2\bo\3\2\2\2\nx\3\2\2\2\f\u0081\3\2\2\2\16\u0087\3\2\2\2\20"+
		"\u0089\3\2\2\2\22\u009a\3\2\2\2\24\u009c\3\2\2\2\26\u00a5\3\2\2\2\30\u00a8"+
		"\3\2\2\2\32\u00b1\3\2\2\2\34\u00b7\3\2\2\2\36\u00b9\3\2\2\2 \u00be\3\2"+
		"\2\2\"\u00c3\3\2\2\2$\u00c9\3\2\2\2&\u00cf\3\2\2\2(\u00d5\3\2\2\2*\u00de"+
		"\3\2\2\2,\u00e3\3\2\2\2.\u00f3\3\2\2\2\60\u00f5\3\2\2\2\62\u00f7\3\2\2"+
		"\2\64\u00f9\3\2\2\2\66\u00fb\3\2\2\28\u00fd\3\2\2\2:\u0101\3\2\2\2<\u0103"+
		"\3\2\2\2>\u0107\3\2\2\2@\u010d\3\2\2\2B\u0112\3\2\2\2D\u0115\3\2\2\2F"+
		"\u011d\3\2\2\2H\u011f\3\2\2\2J\u012e\3\2\2\2L\u0139\3\2\2\2N\u0144\3\2"+
		"\2\2P\u0153\3\2\2\2R\u0155\3\2\2\2T\u0157\3\2\2\2V\u0159\3\2\2\2XZ\5\4"+
		"\3\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\3\3\2\2\2][\3\2\2\2^b"+
		"\5\6\4\2_b\5\20\t\2`b\5T+\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2b\5\3\2\2\2c"+
		"d\5\f\7\2de\7%\2\2ef\5R*\2fg\7\3\2\2gh\5\n\6\2hk\7\4\2\2ij\7\5\2\2jl\5"+
		"H%\2ki\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\5\16\b\2n\7\3\2\2\2op\5R*\2pq\7\5"+
		"\2\2qr\5H%\2r\t\3\2\2\2st\5\b\5\2tu\7\6\2\2uw\3\2\2\2vs\3\2\2\2wz\3\2"+
		"\2\2xv\3\2\2\2xy\3\2\2\2y|\3\2\2\2zx\3\2\2\2{}\5\b\5\2|{\3\2\2\2|}\3\2"+
		"\2\2}\13\3\2\2\2~\u0080\7\"\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\r\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0088\5P)\2\u0085\u0086\7\7\2\2\u0086\u0088\5\34\17\2\u0087\u0084\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\17\3\2\2\2\u0089\u008a\5\f\7\2\u008a\u008b"+
		"\7&\2\2\u008b\u008c\5R*\2\u008c\u008d\7\3\2\2\u008d\u008e\5N(\2\u008e"+
		"\u0091\7\4\2\2\u008f\u0090\7\5\2\2\u0090\u0092\5H%\2\u0091\u008f\3\2\2"+
		"\2\u0091\u0092\3\2\2\2\u0092\21\3\2\2\2\u0093\u009b\5T+\2\u0094\u009b"+
		"\5\26\f\2\u0095\u009b\5\24\13\2\u0096\u009b\5\30\r\2\u0097\u009b\5\32"+
		"\16\2\u0098\u009b\5@!\2\u0099\u009b\5B\"\2\u009a\u0093\3\2\2\2\u009a\u0094"+
		"\3\2\2\2\u009a\u0095\3\2\2\2\u009a\u0096\3\2\2\2\u009a\u0097\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b\23\3\2\2\2\u009c\u009d\5V,\2"+
		"\u009d\u00a0\5R*\2\u009e\u009f\7\5\2\2\u009f\u00a1\5H%\2\u00a0\u009e\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\7\2\2\u00a3"+
		"\u00a4\5\34\17\2\u00a4\25\3\2\2\2\u00a5\u00a6\7$\2\2\u00a6\u00a7\5\34"+
		"\17\2\u00a7\27\3\2\2\2\u00a8\u00a9\7\'\2\2\u00a9\u00aa\7\3\2\2\u00aa\u00ab"+
		"\5\34\17\2\u00ab\u00ac\7\4\2\2\u00ac\u00af\5P)\2\u00ad\u00ae\7(\2\2\u00ae"+
		"\u00b0\5P)\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\31\3\2\2\2"+
		"\u00b1\u00b2\7)\2\2\u00b2\u00b3\7\3\2\2\u00b3\u00b4\5\34\17\2\u00b4\u00b5"+
		"\7\4\2\2\u00b5\u00b6\5P)\2\u00b6\33\3\2\2\2\u00b7\u00b8\5\36\20\2\u00b8"+
		"\35\3\2\2\2\u00b9\u00bc\5 \21\2\u00ba\u00bb\7\b\2\2\u00bb\u00bd\5\36\20"+
		"\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\37\3\2\2\2\u00be\u00c1"+
		"\5\"\22\2\u00bf\u00c0\7\t\2\2\u00c0\u00c2\5 \21\2\u00c1\u00bf\3\2\2\2"+
		"\u00c1\u00c2\3\2\2\2\u00c2!\3\2\2\2\u00c3\u00c7\5$\23\2\u00c4\u00c5\5"+
		"\60\31\2\u00c5\u00c6\5\"\22\2\u00c6\u00c8\3\2\2\2\u00c7\u00c4\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8#\3\2\2\2\u00c9\u00cd\5&\24\2\u00ca\u00cb\5"+
		"\62\32\2\u00cb\u00cc\5$\23\2\u00cc\u00ce\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce%\3\2\2\2\u00cf\u00d3\5(\25\2\u00d0\u00d1\5\64\33"+
		"\2\u00d1\u00d2\5&\24\2\u00d2\u00d4\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\'\3\2\2\2\u00d5\u00d9\5*\26\2\u00d6\u00d7\5\66\34\2\u00d7"+
		"\u00d8\5(\25\2\u00d8\u00da\3\2\2\2\u00d9\u00d6\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da)\3\2\2\2\u00db\u00dd\58\35\2\u00dc\u00db\3\2\2\2\u00dd\u00e0"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e2\5,\27\2\u00e2+\3\2\2\2\u00e3\u00e7\5.\30\2"+
		"\u00e4\u00e6\5:\36\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5"+
		"\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8-\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea"+
		"\u00eb\7\3\2\2\u00eb\u00ec\5\34\17\2\u00ec\u00ed\7\4\2\2\u00ed\u00f4\3"+
		"\2\2\2\u00ee\u00f4\5@!\2\u00ef\u00f4\5D#\2\u00f0\u00f4\5R*\2\u00f1\u00f4"+
		"\5T+\2\u00f2\u00f4\5F$\2\u00f3\u00ea\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3"+
		"\u00ef\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2"+
		"\2\2\u00f4/\3\2\2\2\u00f5\u00f6\t\2\2\2\u00f6\61\3\2\2\2\u00f7\u00f8\t"+
		"\3\2\2\u00f8\63\3\2\2\2\u00f9\u00fa\t\4\2\2\u00fa\65\3\2\2\2\u00fb\u00fc"+
		"\t\5\2\2\u00fc\67\3\2\2\2\u00fd\u00fe\t\6\2\2\u00fe9\3\2\2\2\u00ff\u0102"+
		"\5<\37\2\u0100\u0102\5> \2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102"+
		";\3\2\2\2\u0103\u0104\7\26\2\2\u0104\u0105\5\34\17\2\u0105\u0106\7\27"+
		"\2\2\u0106=\3\2\2\2\u0107\u0108\7\30\2\2\u0108\u0109\5R*\2\u0109\u010a"+
		"\7\3\2\2\u010a\u010b\5J&\2\u010b\u010c\7\4\2\2\u010c?\3\2\2\2\u010d\u010e"+
		"\5R*\2\u010e\u010f\7\3\2\2\u010f\u0110\5J&\2\u0110\u0111\7\4\2\2\u0111"+
		"A\3\2\2\2\u0112\u0113\5\34\17\2\u0113\u0114\5> \2\u0114C\3\2\2\2\u0115"+
		"\u0116\7\'\2\2\u0116\u0117\7\3\2\2\u0117\u0118\5\34\17\2\u0118\u0119\7"+
		"\4\2\2\u0119\u011a\5\34\17\2\u011a\u011b\7(\2\2\u011b\u011c\5\34\17\2"+
		"\u011cE\3\2\2\2\u011d\u011e\t\7\2\2\u011eG\3\2\2\2\u011f\u0120\b%\1\2"+
		"\u0120\u0121\5R*\2\u0121\u0126\3\2\2\2\u0122\u0123\f\3\2\2\u0123\u0125"+
		"\7\31\2\2\u0124\u0122\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2"+
		"\u0126\u0127\3\2\2\2\u0127I\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012a\5"+
		"\34\17\2\u012a\u012b\7\6\2\2\u012b\u012d\3\2\2\2\u012c\u0129\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0132\3\2"+
		"\2\2\u0130\u012e\3\2\2\2\u0131\u0133\5\34\17\2\u0132\u0131\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133K\3\2\2\2\u0134\u0135\5R*\2\u0135\u0136\7\6\2\2\u0136"+
		"\u0138\3\2\2\2\u0137\u0134\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013c"+
		"\u013e\5R*\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013eM\3\2\2\2\u013f"+
		"\u0140\5H%\2\u0140\u0141\7\6\2\2\u0141\u0143\3\2\2\2\u0142\u013f\3\2\2"+
		"\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0148"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0149\5H%\2\u0148\u0147\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149O\3\2\2\2\u014a\u014e\7\32\2\2\u014b\u014d\5\22\n"+
		"\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0154\7\33\2\2"+
		"\u0152\u0154\5\22\n\2\u0153\u014a\3\2\2\2\u0153\u0152\3\2\2\2\u0154Q\3"+
		"\2\2\2\u0155\u0156\7+\2\2\u0156S\3\2\2\2\u0157\u0158\7!\2\2\u0158U\3\2"+
		"\2\2\u0159\u015a\7#\2\2\u015aW\3\2\2\2 [akx|\u0081\u0087\u0091\u009a\u00a0"+
		"\u00af\u00bc\u00c1\u00c7\u00cd\u00d3\u00d9\u00de\u00e7\u00f3\u0101\u0126"+
		"\u012e\u0132\u0139\u013d\u0144\u0148\u014e\u0153";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}