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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		DMOD=46, STRING=47, CHAR=48, INT=49, DOUBLE=50, INLINE_C=51, NAME=52, 
		BLOCK_COMMENT=53, LINE_COMMENT=54, WHITESPACE=55;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_functionDeclaration = 2, 
		RULE_externFunctionDeclaration = 3, RULE_signatureDefinition = 4, RULE_fnArgument = 5, 
		RULE_fnArgumentList = 6, RULE_fnBlock = 7, RULE_structDeclaration = 8, 
		RULE_structMember = 9, RULE_typealiasDeclaration = 10, RULE_importDeclaration = 11, 
		RULE_packageList = 12, RULE_statement = 13, RULE_varDeclaration = 14, 
		RULE_returnStatement = 15, RULE_ifStatement = 16, RULE_whileLoop = 17, 
		RULE_expression = 18, RULE_disjunction = 19, RULE_conjunction = 20, RULE_equalityComparison = 21, 
		RULE_comparison = 22, RULE_additiveExpression = 23, RULE_multiplicativeExpression = 24, 
		RULE_prefixExpression = 25, RULE_postfixExpression = 26, RULE_atomicExpression = 27, 
		RULE_assignmentOperator = 28, RULE_equalityOperation = 29, RULE_comparisonOperation = 30, 
		RULE_additiveOperation = 31, RULE_multiplicativeOperation = 32, RULE_prefixOperation = 33, 
		RULE_postfixOperation = 34, RULE_postfixCall = 35, RULE_memberAccess = 36, 
		RULE_lambda = 37, RULE_ifExpression = 38, RULE_sizeof = 39, RULE_literal = 40, 
		RULE_type = 41, RULE_ltype = 42, RULE_expressionList = 43, RULE_nameList = 44, 
		RULE_typeList = 45, RULE_block = 46, RULE_identifier = 47, RULE_inlineC = 48, 
		RULE_varDeclarationType = 49, RULE_semi = 50;
	public static final String[] ruleNames = {
		"program", "declaration", "functionDeclaration", "externFunctionDeclaration", 
		"signatureDefinition", "fnArgument", "fnArgumentList", "fnBlock", "structDeclaration", 
		"structMember", "typealiasDeclaration", "importDeclaration", "packageList", 
		"statement", "varDeclaration", "returnStatement", "ifStatement", "whileLoop", 
		"expression", "disjunction", "conjunction", "equalityComparison", "comparison", 
		"additiveExpression", "multiplicativeExpression", "prefixExpression", 
		"postfixExpression", "atomicExpression", "assignmentOperator", "equalityOperation", 
		"comparisonOperation", "additiveOperation", "multiplicativeOperation", 
		"prefixOperation", "postfixOperation", "postfixCall", "memberAccess", 
		"lambda", "ifExpression", "sizeof", "literal", "type", "ltype", "expressionList", 
		"nameList", "typeList", "block", "identifier", "inlineC", "varDeclarationType", 
		"semi"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'<'", "'>'", "'('", "')'", "':'", "'extern'", "','", "'='", 
		"'struct'", "'{'", "'}'", "'typealias'", "'import'", "'.'", "'return'", 
		"'if'", "'else'", "'while'", "'||'", "'&&'", "'+='", "'-='", "'*='", "'/='", 
		"'%='", "'=='", "'!='", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'++'", "'--'", "'!'", "'sizeof'", "'const'", "'->'", "'...'", "'var'", 
		"'val'", "';'", "'%%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "DMOD", "STRING", 
		"CHAR", "INT", "DOUBLE", "INLINE_C", "NAME", "BLOCK_COMMENT", "LINE_COMMENT", 
		"WHITESPACE"
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
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
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
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(102);
				importDeclaration();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << INLINE_C))) != 0)) {
				{
				{
				setState(108);
				declaration();
				}
				}
				setState(113);
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
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ExternFunctionDeclarationContext externFunctionDeclaration() {
			return getRuleContext(ExternFunctionDeclarationContext.class,0);
		}
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public TypealiasDeclarationContext typealiasDeclaration() {
			return getRuleContext(TypealiasDeclarationContext.class,0);
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
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				functionDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				externFunctionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				structDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				typealiasDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TypeContext returnType;
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public FnArgumentListContext fnArgumentList() {
			return getRuleContext(FnArgumentListContext.class,0);
		}
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public NameListContext nameList() {
			return getRuleContext(NameListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__0);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(122);
				match(T__1);
				setState(123);
				nameList();
				setState(124);
				match(T__2);
				}
			}

			setState(128);
			match(NAME);
			setState(129);
			match(T__3);
			setState(130);
			fnArgumentList();
			setState(131);
			match(T__4);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(132);
				match(T__5);
				setState(133);
				((FunctionDeclarationContext)_localctx).returnType = type();
				}
			}

			setState(136);
			fnBlock();
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

	public static class ExternFunctionDeclarationContext extends ParserRuleContext {
		public SignatureDefinitionContext signatureDefinition() {
			return getRuleContext(SignatureDefinitionContext.class,0);
		}
		public ExternFunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externFunctionDeclaration; }
	}

	public final ExternFunctionDeclarationContext externFunctionDeclaration() throws RecognitionException {
		ExternFunctionDeclarationContext _localctx = new ExternFunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_externFunctionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__6);
			setState(139);
			signatureDefinition();
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

	public static class SignatureDefinitionContext extends ParserRuleContext {
		public TypeContext returnType;
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SignatureDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signatureDefinition; }
	}

	public final SignatureDefinitionContext signatureDefinition() throws RecognitionException {
		SignatureDefinitionContext _localctx = new SignatureDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_signatureDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__0);
			setState(142);
			match(NAME);
			setState(143);
			match(T__3);
			setState(144);
			typeList();
			setState(145);
			match(T__4);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(146);
				match(T__5);
				setState(147);
				((SignatureDefinitionContext)_localctx).returnType = type();
				}
			}

			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(150);
				semi();
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

	public static class FnArgumentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FnArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnArgument; }
	}

	public final FnArgumentContext fnArgument() throws RecognitionException {
		FnArgumentContext _localctx = new FnArgumentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fnArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(153);
			match(NAME);
			setState(154);
			match(T__5);
			setState(155);
			type();
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
		enterRule(_localctx, 12, RULE_fnArgumentList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(157);
					fnArgument();
					setState(158);
					match(T__7);
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(165);
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

	public static class FnBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public FnBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnBlock; }
	}

	public final FnBlockContext fnBlock() throws RecognitionException {
		FnBlockContext _localctx = new FnBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fnBlock);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__3:
			case T__10:
			case T__15:
			case T__16:
			case T__18:
			case T__31:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__42:
			case T__43:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				block();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(T__8);
				setState(170);
				expression();
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(171);
					semi();
					}
					break;
				}
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

	public static class StructDeclarationContext extends ParserRuleContext {
		public Token extern;
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public NameListContext nameList() {
			return getRuleContext(NameListContext.class,0);
		}
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
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
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(176);
				((StructDeclarationContext)_localctx).extern = match(T__6);
				}
			}

			setState(179);
			match(T__9);
			setState(180);
			match(NAME);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(181);
				match(T__1);
				setState(182);
				nameList();
				setState(183);
				match(T__2);
				}
			}

			setState(187);
			match(T__10);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__42 || _la==T__43) {
				{
				{
				setState(188);
				structMember();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			match(T__11);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(195);
				semi();
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

	public static class StructMemberContext extends ParserRuleContext {
		public VarDeclarationTypeContext varDeclarationType() {
			return getRuleContext(VarDeclarationTypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			varDeclarationType();
			setState(199);
			match(NAME);
			setState(200);
			match(T__5);
			setState(201);
			type();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(202);
				semi();
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

	public static class TypealiasDeclarationContext extends ParserRuleContext {
		public Token extern;
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public TypealiasDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typealiasDeclaration; }
	}

	public final TypealiasDeclarationContext typealiasDeclaration() throws RecognitionException {
		TypealiasDeclarationContext _localctx = new TypealiasDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typealiasDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(205);
				((TypealiasDeclarationContext)_localctx).extern = match(T__6);
				}
			}

			setState(208);
			match(T__12);
			setState(209);
			match(NAME);
			setState(210);
			match(T__8);
			setState(211);
			type();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(212);
				semi();
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

	public static class ImportDeclarationContext extends ParserRuleContext {
		public PackageListContext packageList() {
			return getRuleContext(PackageListContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__13);
			setState(216);
			packageList();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(217);
				semi();
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

	public static class PackageListContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(QuartzParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(QuartzParser.NAME, i);
		}
		public PackageListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageList; }
	}

	public final PackageListContext packageList() throws RecognitionException {
		PackageListContext _localctx = new PackageListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_packageList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(220);
					match(NAME);
					setState(221);
					match(T__14);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(227);
			match(NAME);
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
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
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
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				inlineC();
				setState(231);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(230);
					semi();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				returnStatement();
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(234);
					semi();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				varDeclaration();
				setState(239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(238);
					semi();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				ifStatement();
				setState(243);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(242);
					semi();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(245);
				whileLoop();
				setState(247);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(246);
					semi();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(249);
				expression();
				setState(251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(250);
					semi();
					}
					break;
				}
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
		public VarDeclarationTypeContext varDeclarationType() {
			return getRuleContext(VarDeclarationTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			varDeclarationType();
			setState(256);
			identifier();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(257);
				match(T__5);
				setState(258);
				type();
				}
			}

			setState(261);
			match(T__8);
			setState(262);
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

	public static class ReturnStatementContext extends ParserRuleContext {
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
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(T__15);
			setState(265);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__16);
			setState(268);
			match(T__3);
			setState(269);
			expression();
			setState(270);
			match(T__4);
			setState(271);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(272);
				match(T__17);
				setState(273);
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
		enterRule(_localctx, 34, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(T__18);
			setState(277);
			match(T__3);
			setState(278);
			expression();
			setState(279);
			match(T__4);
			setState(280);
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
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			disjunction();
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(283);
				assignmentOperator();
				setState(284);
				expression();
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
		enterRule(_localctx, 38, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			conjunction();
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(289);
				match(T__19);
				setState(290);
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
		enterRule(_localctx, 40, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			equalityComparison();
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(294);
				match(T__20);
				setState(295);
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
		enterRule(_localctx, 42, RULE_equalityComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			comparison();
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(299);
				equalityOperation();
				setState(300);
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
		enterRule(_localctx, 44, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			additiveExpression();
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(305);
				comparisonOperation();
				setState(306);
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
		enterRule(_localctx, 46, RULE_additiveExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			multiplicativeExpression();
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(311);
				additiveOperation();
				setState(312);
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
		enterRule(_localctx, 48, RULE_multiplicativeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			prefixExpression();
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(317);
				multiplicativeOperation();
				setState(318);
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
		enterRule(_localctx, 50, RULE_prefixExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) {
				{
				{
				setState(322);
				prefixOperation();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
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
		enterRule(_localctx, 52, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			atomicExpression();
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(331);
					postfixOperation();
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public SizeofContext sizeof() {
			return getRuleContext(SizeofContext.class,0);
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
		enterRule(_localctx, 54, RULE_atomicExpression);
		try {
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				match(T__3);
				setState(338);
				expression();
				setState(339);
				match(T__4);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				lambda();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				ifExpression();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 4);
				{
				setState(343);
				sizeof();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(344);
				identifier();
				}
				break;
			case INLINE_C:
				enterOuterAlt(_localctx, 6);
				{
				setState(345);
				inlineC();
				}
				break;
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(346);
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
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

	public static class EqualityOperationContext extends ParserRuleContext {
		public EqualityOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOperation; }
	}

	public final EqualityOperationContext equalityOperation() throws RecognitionException {
		EqualityOperationContext _localctx = new EqualityOperationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__27) ) {
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
		enterRule(_localctx, 60, RULE_comparisonOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__28) | (1L << T__29))) != 0)) ) {
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
		enterRule(_localctx, 62, RULE_additiveOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__31) ) {
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
		enterRule(_localctx, 64, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
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
		enterRule(_localctx, 66, RULE_prefixOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
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
		enterRule(_localctx, 68, RULE_postfixOperation);
		try {
			setState(365);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(T__36);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				postfixCall();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(364);
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
		enterRule(_localctx, 70, RULE_postfixCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__3);
			setState(368);
			expressionList();
			setState(369);
			match(T__4);
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
		enterRule(_localctx, 72, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(T__14);
			setState(372);
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

	public static class LambdaContext extends ParserRuleContext {
		public TypeContext returnType;
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public FnArgumentListContext fnArgumentList() {
			return getRuleContext(FnArgumentListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(T__0);
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(375);
				match(T__3);
				setState(376);
				fnArgumentList();
				setState(377);
				match(T__4);
				}
				break;
			}
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(381);
				match(T__5);
				setState(382);
				((LambdaContext)_localctx).returnType = type();
				}
			}

			setState(385);
			fnBlock();
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
		enterRule(_localctx, 76, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__16);
			setState(388);
			match(T__3);
			setState(389);
			((IfExpressionContext)_localctx).test = expression();
			setState(390);
			match(T__4);
			setState(391);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(392);
			match(T__17);
			setState(393);
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

	public static class SizeofContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SizeofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizeof; }
	}

	public final SizeofContext sizeof() throws RecognitionException {
		SizeofContext _localctx = new SizeofContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sizeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(T__38);
			setState(396);
			match(T__3);
			setState(397);
			type();
			setState(398);
			match(T__4);
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
		enterRule(_localctx, 80, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
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

	public static class TypeContext extends ParserRuleContext {
		public Token isConst;
		public LtypeContext ltype() {
			return getRuleContext(LtypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39) {
				{
				setState(402);
				((TypeContext)_localctx).isConst = match(T__39);
				}
			}

			setState(405);
			ltype(0);
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

	public static class LtypeContext extends ParserRuleContext {
		public TypeListContext args;
		public TypeContext returnType;
		public Token ptr;
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LtypeContext ltype() {
			return getRuleContext(LtypeContext.class,0);
		}
		public LtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltype; }
	}

	public final LtypeContext ltype() throws RecognitionException {
		return ltype(0);
	}

	private LtypeContext ltype(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LtypeContext _localctx = new LtypeContext(_ctx, _parentState);
		LtypeContext _prevctx = _localctx;
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_ltype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(408);
				match(NAME);
				setState(413);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(409);
					match(T__1);
					setState(410);
					typeList();
					setState(411);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__3:
				{
				setState(415);
				match(T__3);
				setState(416);
				((LtypeContext)_localctx).args = typeList();
				setState(417);
				match(T__4);
				setState(418);
				match(T__40);
				setState(419);
				((LtypeContext)_localctx).returnType = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(427);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LtypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ltype);
					setState(423);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(424);
					((LtypeContext)_localctx).ptr = match(T__32);
					}
					} 
				}
				setState(429);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 86, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(430);
					expression();
					setState(431);
					match(T__7);
					}
					} 
				}
				setState(437);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__16) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << NAME))) != 0)) {
				{
				setState(438);
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
		public List<TerminalNode> NAME() { return getTokens(QuartzParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(QuartzParser.NAME, i);
		}
		public NameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameList; }
	}

	public final NameListContext nameList() throws RecognitionException {
		NameListContext _localctx = new NameListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_nameList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(441);
					match(NAME);
					setState(442);
					match(T__7);
					}
					} 
				}
				setState(447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(448);
				match(NAME);
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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_typeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(451);
					type();
					setState(452);
					match(T__7);
					}
					} 
				}
				setState(458);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			setState(461);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__41:
				{
				setState(459);
				((TypeListContext)_localctx).vararg = match(T__41);
				}
				break;
			case T__3:
			case T__39:
			case NAME:
				{
				setState(460);
				type();
				}
				break;
			case T__2:
			case T__4:
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
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_block);
		int _la;
		try {
			setState(475);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				match(T__10);
				setState(467);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__42) | (1L << T__43) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << NAME))) != 0)) {
					{
					{
					setState(464);
					statement();
					}
					}
					setState(469);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(470);
				match(T__11);
				setState(472);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(471);
					semi();
					}
					break;
				}
				}
				break;
			case T__0:
			case T__3:
			case T__15:
			case T__16:
			case T__18:
			case T__31:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__42:
			case T__43:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
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
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(NAME);
			setState(482);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(478);
				match(T__1);
				setState(479);
				typeList();
				setState(480);
				match(T__2);
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

	public static class InlineCContext extends ParserRuleContext {
		public TerminalNode INLINE_C() { return getToken(QuartzParser.INLINE_C, 0); }
		public InlineCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineC; }
	}

	public final InlineCContext inlineC() throws RecognitionException {
		InlineCContext _localctx = new InlineCContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_inlineC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
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
		public VarDeclarationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclarationType; }
	}

	public final VarDeclarationTypeContext varDeclarationType() throws RecognitionException {
		VarDeclarationTypeContext _localctx = new VarDeclarationTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_varDeclarationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			_la = _input.LA(1);
			if ( !(_la==T__42 || _la==T__43) ) {
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

	public static class SemiContext extends ParserRuleContext {
		public SemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semi; }
	}

	public final SemiContext semi() throws RecognitionException {
		SemiContext _localctx = new SemiContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_semi);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(489); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(488);
					match(T__44);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(491); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 42:
			return ltype_sempred((LtypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ltype_sempred(LtypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u01f0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\7\2j\n\2\f\2\16\2m\13\2\3\2\7\2p\n\2\f\2\16\2s\13\2\3\3\3\3\3"+
		"\3\3\3\3\3\5\3z\n\3\3\4\3\4\3\4\3\4\3\4\5\4\u0081\n\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\u0089\n\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6\u0097\n\6\3\6\5\6\u009a\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b\u00a3"+
		"\n\b\f\b\16\b\u00a6\13\b\3\b\5\b\u00a9\n\b\3\t\3\t\3\t\3\t\5\t\u00af\n"+
		"\t\5\t\u00b1\n\t\3\n\5\n\u00b4\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00bc\n"+
		"\n\3\n\3\n\7\n\u00c0\n\n\f\n\16\n\u00c3\13\n\3\n\3\n\5\n\u00c7\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00ce\n\13\3\f\5\f\u00d1\n\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u00d8\n\f\3\r\3\r\3\r\5\r\u00dd\n\r\3\16\3\16\7\16\u00e1\n\16"+
		"\f\16\16\16\u00e4\13\16\3\16\3\16\3\17\3\17\5\17\u00ea\n\17\3\17\3\17"+
		"\5\17\u00ee\n\17\3\17\3\17\5\17\u00f2\n\17\3\17\3\17\5\17\u00f6\n\17\3"+
		"\17\3\17\5\17\u00fa\n\17\3\17\3\17\5\17\u00fe\n\17\5\17\u0100\n\17\3\20"+
		"\3\20\3\20\3\20\5\20\u0106\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0115\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\5\24\u0121\n\24\3\25\3\25\3\25\5\25\u0126\n\25\3"+
		"\26\3\26\3\26\5\26\u012b\n\26\3\27\3\27\3\27\3\27\5\27\u0131\n\27\3\30"+
		"\3\30\3\30\3\30\5\30\u0137\n\30\3\31\3\31\3\31\3\31\5\31\u013d\n\31\3"+
		"\32\3\32\3\32\3\32\5\32\u0143\n\32\3\33\7\33\u0146\n\33\f\33\16\33\u0149"+
		"\13\33\3\33\3\33\3\34\3\34\7\34\u014f\n\34\f\34\16\34\u0152\13\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u015e\n\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\5$\u0170\n$\3%\3%\3%"+
		"\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u017e\n\'\3\'\3\'\5\'\u0182\n\'\3"+
		"\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3+\5+\u0196\n+\3+"+
		"\3+\3,\3,\3,\3,\3,\3,\5,\u01a0\n,\3,\3,\3,\3,\3,\3,\5,\u01a8\n,\3,\3,"+
		"\7,\u01ac\n,\f,\16,\u01af\13,\3-\3-\3-\7-\u01b4\n-\f-\16-\u01b7\13-\3"+
		"-\5-\u01ba\n-\3.\3.\7.\u01be\n.\f.\16.\u01c1\13.\3.\5.\u01c4\n.\3/\3/"+
		"\3/\7/\u01c9\n/\f/\16/\u01cc\13/\3/\3/\5/\u01d0\n/\3\60\3\60\7\60\u01d4"+
		"\n\60\f\60\16\60\u01d7\13\60\3\60\3\60\5\60\u01db\n\60\3\60\5\60\u01de"+
		"\n\60\3\61\3\61\3\61\3\61\3\61\5\61\u01e5\n\61\3\62\3\62\3\63\3\63\3\64"+
		"\6\64\u01ec\n\64\r\64\16\64\u01ed\3\64\2\3V\65\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdf\2\n\4\2"+
		"\13\13\30\34\3\2\35\36\4\2\4\5\37 \3\2!\"\3\2#%\4\2\"\"&(\3\2\61\64\3"+
		"\2-.\u0204\2k\3\2\2\2\4y\3\2\2\2\6{\3\2\2\2\b\u008c\3\2\2\2\n\u008f\3"+
		"\2\2\2\f\u009b\3\2\2\2\16\u00a4\3\2\2\2\20\u00b0\3\2\2\2\22\u00b3\3\2"+
		"\2\2\24\u00c8\3\2\2\2\26\u00d0\3\2\2\2\30\u00d9\3\2\2\2\32\u00e2\3\2\2"+
		"\2\34\u00ff\3\2\2\2\36\u0101\3\2\2\2 \u010a\3\2\2\2\"\u010d\3\2\2\2$\u0116"+
		"\3\2\2\2&\u011c\3\2\2\2(\u0122\3\2\2\2*\u0127\3\2\2\2,\u012c\3\2\2\2."+
		"\u0132\3\2\2\2\60\u0138\3\2\2\2\62\u013e\3\2\2\2\64\u0147\3\2\2\2\66\u014c"+
		"\3\2\2\28\u015d\3\2\2\2:\u015f\3\2\2\2<\u0161\3\2\2\2>\u0163\3\2\2\2@"+
		"\u0165\3\2\2\2B\u0167\3\2\2\2D\u0169\3\2\2\2F\u016f\3\2\2\2H\u0171\3\2"+
		"\2\2J\u0175\3\2\2\2L\u0178\3\2\2\2N\u0185\3\2\2\2P\u018d\3\2\2\2R\u0192"+
		"\3\2\2\2T\u0195\3\2\2\2V\u01a7\3\2\2\2X\u01b5\3\2\2\2Z\u01bf\3\2\2\2\\"+
		"\u01ca\3\2\2\2^\u01dd\3\2\2\2`\u01df\3\2\2\2b\u01e6\3\2\2\2d\u01e8\3\2"+
		"\2\2f\u01eb\3\2\2\2hj\5\30\r\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2"+
		"lq\3\2\2\2mk\3\2\2\2np\5\4\3\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"r\3\3\2\2\2sq\3\2\2\2tz\5\6\4\2uz\5\b\5\2vz\5\22\n\2wz\5\26\f\2xz\5b\62"+
		"\2yt\3\2\2\2yu\3\2\2\2yv\3\2\2\2yw\3\2\2\2yx\3\2\2\2z\5\3\2\2\2{\u0080"+
		"\7\3\2\2|}\7\4\2\2}~\5Z.\2~\177\7\5\2\2\177\u0081\3\2\2\2\u0080|\3\2\2"+
		"\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\66\2\2\u0083"+
		"\u0084\7\6\2\2\u0084\u0085\5\16\b\2\u0085\u0088\7\7\2\2\u0086\u0087\7"+
		"\b\2\2\u0087\u0089\5T+\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\5\20\t\2\u008b\7\3\2\2\2\u008c\u008d\7\t\2"+
		"\2\u008d\u008e\5\n\6\2\u008e\t\3\2\2\2\u008f\u0090\7\3\2\2\u0090\u0091"+
		"\7\66\2\2\u0091\u0092\7\6\2\2\u0092\u0093\5\\/\2\u0093\u0096\7\7\2\2\u0094"+
		"\u0095\7\b\2\2\u0095\u0097\5T+\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2"+
		"\2\u0097\u0099\3\2\2\2\u0098\u009a\5f\64\2\u0099\u0098\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\13\3\2\2\2\u009b\u009c\7\66\2\2\u009c\u009d\7\b\2\2\u009d"+
		"\u009e\5T+\2\u009e\r\3\2\2\2\u009f\u00a0\5\f\7\2\u00a0\u00a1\7\n\2\2\u00a1"+
		"\u00a3\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00a9\5\f\7\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\17\3\2\2"+
		"\2\u00aa\u00b1\5^\60\2\u00ab\u00ac\7\13\2\2\u00ac\u00ae\5&\24\2\u00ad"+
		"\u00af\5f\64\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2"+
		"\2\2\u00b0\u00aa\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1\21\3\2\2\2\u00b2\u00b4"+
		"\7\t\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\7\f\2\2\u00b6\u00bb\7\66\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5"+
		"Z.\2\u00b9\u00ba\7\5\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c1\7\r\2\2\u00be\u00c0\5\24"+
		"\13\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c6\7\16"+
		"\2\2\u00c5\u00c7\5f\64\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\23\3\2\2\2\u00c8\u00c9\5d\63\2\u00c9\u00ca\7\66\2\2\u00ca\u00cb\7\b\2"+
		"\2\u00cb\u00cd\5T+\2\u00cc\u00ce\5f\64\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\25\3\2\2\2\u00cf\u00d1\7\t\2\2\u00d0\u00cf\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7\17\2\2\u00d3\u00d4\7"+
		"\66\2\2\u00d4\u00d5\7\13\2\2\u00d5\u00d7\5T+\2\u00d6\u00d8\5f\64\2\u00d7"+
		"\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\27\3\2\2\2\u00d9\u00da\7\20\2"+
		"\2\u00da\u00dc\5\32\16\2\u00db\u00dd\5f\64\2\u00dc\u00db\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\31\3\2\2\2\u00de\u00df\7\66\2\2\u00df\u00e1\7\21"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7\66"+
		"\2\2\u00e6\33\3\2\2\2\u00e7\u00e9\5b\62\2\u00e8\u00ea\5f\64\2\u00e9\u00e8"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u0100\3\2\2\2\u00eb\u00ed\5 \21\2\u00ec"+
		"\u00ee\5f\64\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u0100\3\2"+
		"\2\2\u00ef\u00f1\5\36\20\2\u00f0\u00f2\5f\64\2\u00f1\u00f0\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u0100\3\2\2\2\u00f3\u00f5\5\"\22\2\u00f4\u00f6\5"+
		"f\64\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u0100\3\2\2\2\u00f7"+
		"\u00f9\5$\23\2\u00f8\u00fa\5f\64\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u0100\3\2\2\2\u00fb\u00fd\5&\24\2\u00fc\u00fe\5f\64\2\u00fd"+
		"\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00e7\3\2"+
		"\2\2\u00ff\u00eb\3\2\2\2\u00ff\u00ef\3\2\2\2\u00ff\u00f3\3\2\2\2\u00ff"+
		"\u00f7\3\2\2\2\u00ff\u00fb\3\2\2\2\u0100\35\3\2\2\2\u0101\u0102\5d\63"+
		"\2\u0102\u0105\5`\61\2\u0103\u0104\7\b\2\2\u0104\u0106\5T+\2\u0105\u0103"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7\13\2\2"+
		"\u0108\u0109\5&\24\2\u0109\37\3\2\2\2\u010a\u010b\7\22\2\2\u010b\u010c"+
		"\5&\24\2\u010c!\3\2\2\2\u010d\u010e\7\23\2\2\u010e\u010f\7\6\2\2\u010f"+
		"\u0110\5&\24\2\u0110\u0111\7\7\2\2\u0111\u0114\5^\60\2\u0112\u0113\7\24"+
		"\2\2\u0113\u0115\5^\60\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"#\3\2\2\2\u0116\u0117\7\25\2\2\u0117\u0118\7\6\2\2\u0118\u0119\5&\24\2"+
		"\u0119\u011a\7\7\2\2\u011a\u011b\5^\60\2\u011b%\3\2\2\2\u011c\u0120\5"+
		"(\25\2\u011d\u011e\5:\36\2\u011e\u011f\5&\24\2\u011f\u0121\3\2\2\2\u0120"+
		"\u011d\3\2\2\2\u0120\u0121\3\2\2\2\u0121\'\3\2\2\2\u0122\u0125\5*\26\2"+
		"\u0123\u0124\7\26\2\2\u0124\u0126\5(\25\2\u0125\u0123\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126)\3\2\2\2\u0127\u012a\5,\27\2\u0128\u0129\7\27\2\2\u0129"+
		"\u012b\5*\26\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b+\3\2\2\2"+
		"\u012c\u0130\5.\30\2\u012d\u012e\5<\37\2\u012e\u012f\5,\27\2\u012f\u0131"+
		"\3\2\2\2\u0130\u012d\3\2\2\2\u0130\u0131\3\2\2\2\u0131-\3\2\2\2\u0132"+
		"\u0136\5\60\31\2\u0133\u0134\5> \2\u0134\u0135\5.\30\2\u0135\u0137\3\2"+
		"\2\2\u0136\u0133\3\2\2\2\u0136\u0137\3\2\2\2\u0137/\3\2\2\2\u0138\u013c"+
		"\5\62\32\2\u0139\u013a\5@!\2\u013a\u013b\5\60\31\2\u013b\u013d\3\2\2\2"+
		"\u013c\u0139\3\2\2\2\u013c\u013d\3\2\2\2\u013d\61\3\2\2\2\u013e\u0142"+
		"\5\64\33\2\u013f\u0140\5B\"\2\u0140\u0141\5\62\32\2\u0141\u0143\3\2\2"+
		"\2\u0142\u013f\3\2\2\2\u0142\u0143\3\2\2\2\u0143\63\3\2\2\2\u0144\u0146"+
		"\5D#\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\5\66"+
		"\34\2\u014b\65\3\2\2\2\u014c\u0150\58\35\2\u014d\u014f\5F$\2\u014e\u014d"+
		"\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\67\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\7\6\2\2\u0154\u0155\5&\24"+
		"\2\u0155\u0156\7\7\2\2\u0156\u015e\3\2\2\2\u0157\u015e\5L\'\2\u0158\u015e"+
		"\5N(\2\u0159\u015e\5P)\2\u015a\u015e\5`\61\2\u015b\u015e\5b\62\2\u015c"+
		"\u015e\5R*\2\u015d\u0153\3\2\2\2\u015d\u0157\3\2\2\2\u015d\u0158\3\2\2"+
		"\2\u015d\u0159\3\2\2\2\u015d\u015a\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015c"+
		"\3\2\2\2\u015e9\3\2\2\2\u015f\u0160\t\2\2\2\u0160;\3\2\2\2\u0161\u0162"+
		"\t\3\2\2\u0162=\3\2\2\2\u0163\u0164\t\4\2\2\u0164?\3\2\2\2\u0165\u0166"+
		"\t\5\2\2\u0166A\3\2\2\2\u0167\u0168\t\6\2\2\u0168C\3\2\2\2\u0169\u016a"+
		"\t\7\2\2\u016aE\3\2\2\2\u016b\u0170\7&\2\2\u016c\u0170\7\'\2\2\u016d\u0170"+
		"\5H%\2\u016e\u0170\5J&\2\u016f\u016b\3\2\2\2\u016f\u016c\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u016f\u016e\3\2\2\2\u0170G\3\2\2\2\u0171\u0172\7\6\2\2"+
		"\u0172\u0173\5X-\2\u0173\u0174\7\7\2\2\u0174I\3\2\2\2\u0175\u0176\7\21"+
		"\2\2\u0176\u0177\5`\61\2\u0177K\3\2\2\2\u0178\u017d\7\3\2\2\u0179\u017a"+
		"\7\6\2\2\u017a\u017b\5\16\b\2\u017b\u017c\7\7\2\2\u017c\u017e\3\2\2\2"+
		"\u017d\u0179\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u0180"+
		"\7\b\2\2\u0180\u0182\5T+\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0184\5\20\t\2\u0184M\3\2\2\2\u0185\u0186\7\23\2"+
		"\2\u0186\u0187\7\6\2\2\u0187\u0188\5&\24\2\u0188\u0189\7\7\2\2\u0189\u018a"+
		"\5&\24\2\u018a\u018b\7\24\2\2\u018b\u018c\5&\24\2\u018cO\3\2\2\2\u018d"+
		"\u018e\7)\2\2\u018e\u018f\7\6\2\2\u018f\u0190\5T+\2\u0190\u0191\7\7\2"+
		"\2\u0191Q\3\2\2\2\u0192\u0193\t\b\2\2\u0193S\3\2\2\2\u0194\u0196\7*\2"+
		"\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198"+
		"\5V,\2\u0198U\3\2\2\2\u0199\u019a\b,\1\2\u019a\u019f\7\66\2\2\u019b\u019c"+
		"\7\4\2\2\u019c\u019d\5\\/\2\u019d\u019e\7\5\2\2\u019e\u01a0\3\2\2\2\u019f"+
		"\u019b\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a8\3\2\2\2\u01a1\u01a2\7\6"+
		"\2\2\u01a2\u01a3\5\\/\2\u01a3\u01a4\7\7\2\2\u01a4\u01a5\7+\2\2\u01a5\u01a6"+
		"\5T+\2\u01a6\u01a8\3\2\2\2\u01a7\u0199\3\2\2\2\u01a7\u01a1\3\2\2\2\u01a8"+
		"\u01ad\3\2\2\2\u01a9\u01aa\f\4\2\2\u01aa\u01ac\7#\2\2\u01ab\u01a9\3\2"+
		"\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"W\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\5&\24\2\u01b1\u01b2\7\n\2\2"+
		"\u01b2\u01b4\3\2\2\2\u01b3\u01b0\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3"+
		"\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8"+
		"\u01ba\5&\24\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01baY\3\2\2\2"+
		"\u01bb\u01bc\7\66\2\2\u01bc\u01be\7\n\2\2\u01bd\u01bb\3\2\2\2\u01be\u01c1"+
		"\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1"+
		"\u01bf\3\2\2\2\u01c2\u01c4\7\66\2\2\u01c3\u01c2\3\2\2\2\u01c3\u01c4\3"+
		"\2\2\2\u01c4[\3\2\2\2\u01c5\u01c6\5T+\2\u01c6\u01c7\7\n\2\2\u01c7\u01c9"+
		"\3\2\2\2\u01c8\u01c5\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca"+
		"\u01cb\3\2\2\2\u01cb\u01cf\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0\7,"+
		"\2\2\u01ce\u01d0\5T+\2\u01cf\u01cd\3\2\2\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0]\3\2\2\2\u01d1\u01d5\7\r\2\2\u01d2\u01d4\5\34\17\2\u01d3"+
		"\u01d2\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2"+
		"\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da\7\16\2\2\u01d9"+
		"\u01db\5f\64\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01de\3\2"+
		"\2\2\u01dc\u01de\5\34\17\2\u01dd\u01d1\3\2\2\2\u01dd\u01dc\3\2\2\2\u01de"+
		"_\3\2\2\2\u01df\u01e4\7\66\2\2\u01e0\u01e1\7\4\2\2\u01e1\u01e2\5\\/\2"+
		"\u01e2\u01e3\7\5\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e0\3\2\2\2\u01e4\u01e5"+
		"\3\2\2\2\u01e5a\3\2\2\2\u01e6\u01e7\7\65\2\2\u01e7c\3\2\2\2\u01e8\u01e9"+
		"\t\t\2\2\u01e9e\3\2\2\2\u01ea\u01ec\7/\2\2\u01eb\u01ea\3\2\2\2\u01ec\u01ed"+
		"\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01eeg\3\2\2\2;kqy\u0080"+
		"\u0088\u0096\u0099\u00a4\u00a8\u00ae\u00b0\u00b3\u00bb\u00c1\u00c6\u00cd"+
		"\u00d0\u00d7\u00dc\u00e2\u00e9\u00ed\u00f1\u00f5\u00f9\u00fd\u00ff\u0105"+
		"\u0114\u0120\u0125\u012a\u0130\u0136\u013c\u0142\u0147\u0150\u015d\u016f"+
		"\u017d\u0181\u0195\u019f\u01a7\u01ad\u01b5\u01b9\u01bf\u01c3\u01ca\u01cf"+
		"\u01d5\u01da\u01dd\u01e4\u01ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}