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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, DMOD=55, STRING=56, CHAR=57, INT=58, DOUBLE=59, INLINE_C=60, 
		NAME=61, BLOCK_COMMENT=62, LINE_COMMENT=63, WHITESPACE=64;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_functionDeclaration = 2, 
		RULE_externFunctionDeclaration = 3, RULE_signatureDefinition = 4, RULE_fnArgument = 5, 
		RULE_fnArgumentList = 6, RULE_structDeclaration = 7, RULE_structMember = 8, 
		RULE_typealiasDeclaration = 9, RULE_importDeclaration = 10, RULE_packageList = 11, 
		RULE_statement = 12, RULE_varDeclaration = 13, RULE_returnStatement = 14, 
		RULE_ifStatement = 15, RULE_whileLoop = 16, RULE_breakStatement = 17, 
		RULE_continueStatement = 18, RULE_expression = 19, RULE_disjunction = 20, 
		RULE_conjunction = 21, RULE_equalityComparison = 22, RULE_comparison = 23, 
		RULE_bitshiftExpression = 24, RULE_additiveExpression = 25, RULE_multiplicativeExpression = 26, 
		RULE_prefixExpression = 27, RULE_postfixExpression = 28, RULE_atomicExpression = 29, 
		RULE_assignmentOperation = 30, RULE_disjunctionOperation = 31, RULE_conjunctionOperation = 32, 
		RULE_equalityOperation = 33, RULE_comparisonOperation = 34, RULE_bitshiftOperation = 35, 
		RULE_additiveOperation = 36, RULE_multiplicativeOperation = 37, RULE_prefixOperation = 38, 
		RULE_postfixOperation = 39, RULE_postfixCall = 40, RULE_memberAccess = 41, 
		RULE_dotCall = 42, RULE_lambda = 43, RULE_ifExpression = 44, RULE_sizeof = 45, 
		RULE_literal = 46, RULE_type = 47, RULE_ltype = 48, RULE_expressionList = 49, 
		RULE_nameList = 50, RULE_typeList = 51, RULE_statementBlock = 52, RULE_block = 53, 
		RULE_identifier = 54, RULE_inlineC = 55, RULE_varDeclarationType = 56, 
		RULE_semi = 57;
	public static final String[] ruleNames = {
		"program", "declaration", "functionDeclaration", "externFunctionDeclaration", 
		"signatureDefinition", "fnArgument", "fnArgumentList", "structDeclaration", 
		"structMember", "typealiasDeclaration", "importDeclaration", "packageList", 
		"statement", "varDeclaration", "returnStatement", "ifStatement", "whileLoop", 
		"breakStatement", "continueStatement", "expression", "disjunction", "conjunction", 
		"equalityComparison", "comparison", "bitshiftExpression", "additiveExpression", 
		"multiplicativeExpression", "prefixExpression", "postfixExpression", "atomicExpression", 
		"assignmentOperation", "disjunctionOperation", "conjunctionOperation", 
		"equalityOperation", "comparisonOperation", "bitshiftOperation", "additiveOperation", 
		"multiplicativeOperation", "prefixOperation", "postfixOperation", "postfixCall", 
		"memberAccess", "dotCall", "lambda", "ifExpression", "sizeof", "literal", 
		"type", "ltype", "expressionList", "nameList", "typeList", "statementBlock", 
		"block", "identifier", "inlineC", "varDeclarationType", "semi"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "')'", "':'", "'extern'", "','", "'struct'", "'{'", 
		"'}'", "'typealias'", "'='", "'import'", "'.'", "'return'", "'if'", "'else'", 
		"'while'", "'break'", "'continue'", "'+='", "'-='", "'*='", "'/='", "'%='", 
		"'&='", "'|='", "'^='", "'<'", "'>'", "'||'", "'|'", "'^'", "'&&'", "'&'", 
		"'=='", "'!='", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", 
		"'--'", "'!'", "'~'", "'->'", "'sizeof'", "'const'", "'...'", "'var'", 
		"'val'", "';'", "'%%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "DMOD", "STRING", "CHAR", "INT", 
		"DOUBLE", "INLINE_C", "NAME", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
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
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(116);
				importDeclaration();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__6) | (1L << T__9) | (1L << INLINE_C))) != 0)) {
				{
				{
				setState(122);
				declaration();
				}
				}
				setState(127);
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
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				functionDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				externFunctionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				structDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				typealiasDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			setState(135);
			match(T__0);
			setState(136);
			match(NAME);
			setState(137);
			match(T__1);
			setState(138);
			fnArgumentList();
			setState(139);
			match(T__2);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(140);
				match(T__3);
				setState(141);
				((FunctionDeclarationContext)_localctx).returnType = type();
				}
			}

			setState(144);
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
			setState(146);
			match(T__4);
			setState(147);
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
			setState(149);
			match(T__0);
			setState(150);
			match(NAME);
			setState(151);
			match(T__1);
			setState(152);
			typeList();
			setState(153);
			match(T__2);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(154);
				match(T__3);
				setState(155);
				((SignatureDefinitionContext)_localctx).returnType = type();
				}
			}

			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(158);
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
			setState(161);
			match(NAME);
			setState(162);
			match(T__3);
			setState(163);
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
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(165);
					fnArgument();
					setState(166);
					match(T__5);
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(173);
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

	public static class StructDeclarationContext extends ParserRuleContext {
		public Token extern;
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
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
		enterRule(_localctx, 14, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(176);
				((StructDeclarationContext)_localctx).extern = match(T__4);
				}
			}

			setState(179);
			match(T__6);
			setState(180);
			match(NAME);
			setState(181);
			match(T__7);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__51 || _la==T__52) {
				{
				{
				setState(182);
				structMember();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(T__8);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(189);
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
		enterRule(_localctx, 16, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			varDeclarationType();
			setState(193);
			match(NAME);
			setState(194);
			match(T__3);
			setState(195);
			type();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(196);
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
		enterRule(_localctx, 18, RULE_typealiasDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(199);
				((TypealiasDeclarationContext)_localctx).extern = match(T__4);
				}
			}

			setState(202);
			match(T__9);
			setState(203);
			match(NAME);
			setState(204);
			match(T__10);
			setState(205);
			type();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(206);
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
		enterRule(_localctx, 20, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__11);
			setState(210);
			packageList();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(211);
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
		enterRule(_localctx, 22, RULE_packageList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					match(NAME);
					setState(215);
					match(T__12);
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(221);
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
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
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
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				inlineC();
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(224);
					semi();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				returnStatement();
				setState(229);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(228);
					semi();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				varDeclaration();
				setState(233);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(232);
					semi();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				ifStatement();
				setState(237);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(236);
					semi();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				whileLoop();
				setState(241);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(240);
					semi();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				breakStatement();
				setState(245);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(244);
					semi();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(247);
				continueStatement();
				setState(249);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(248);
					semi();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(251);
				expression();
				setState(253);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(252);
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
		enterRule(_localctx, 26, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			varDeclarationType();
			setState(258);
			identifier();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(259);
				match(T__3);
				setState(260);
				type();
				}
			}

			setState(263);
			match(T__10);
			setState(264);
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
		enterRule(_localctx, 28, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(T__13);
			setState(267);
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
		enterRule(_localctx, 30, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__14);
			setState(270);
			match(T__1);
			setState(271);
			expression();
			setState(272);
			match(T__2);
			setState(273);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(274);
				match(T__15);
				setState(275);
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
		enterRule(_localctx, 32, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__16);
			setState(279);
			match(T__1);
			setState(280);
			expression();
			setState(281);
			match(T__2);
			setState(282);
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

	public static class BreakStatementContext extends ParserRuleContext {
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__17);
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

	public static class ContinueStatementContext extends ParserRuleContext {
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__18);
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
		public AssignmentOperationContext assignmentOperation() {
			return getRuleContext(AssignmentOperationContext.class,0);
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
		enterRule(_localctx, 38, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			disjunction();
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(289);
				assignmentOperation();
				setState(290);
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
		public DisjunctionOperationContext disjunctionOperation() {
			return getRuleContext(DisjunctionOperationContext.class,0);
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
		enterRule(_localctx, 40, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			conjunction();
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(295);
				disjunctionOperation();
				setState(296);
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
		public ConjunctionOperationContext conjunctionOperation() {
			return getRuleContext(ConjunctionOperationContext.class,0);
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
		enterRule(_localctx, 42, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			equalityComparison();
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(301);
				conjunctionOperation();
				setState(302);
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
		enterRule(_localctx, 44, RULE_equalityComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			comparison();
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(307);
				equalityOperation();
				setState(308);
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
		public BitshiftExpressionContext bitshiftExpression() {
			return getRuleContext(BitshiftExpressionContext.class,0);
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
		enterRule(_localctx, 46, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			bitshiftExpression();
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(313);
				comparisonOperation();
				setState(314);
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

	public static class BitshiftExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public BitshiftOperationContext bitshiftOperation() {
			return getRuleContext(BitshiftOperationContext.class,0);
		}
		public BitshiftExpressionContext bitshiftExpression() {
			return getRuleContext(BitshiftExpressionContext.class,0);
		}
		public BitshiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitshiftExpression; }
	}

	public final BitshiftExpressionContext bitshiftExpression() throws RecognitionException {
		BitshiftExpressionContext _localctx = new BitshiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bitshiftExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			additiveExpression();
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(319);
				bitshiftOperation();
				setState(320);
				bitshiftExpression();
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
		enterRule(_localctx, 50, RULE_additiveExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			multiplicativeExpression();
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(325);
				additiveOperation();
				setState(326);
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
		enterRule(_localctx, 52, RULE_multiplicativeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			prefixExpression();
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(331);
				multiplicativeOperation();
				setState(332);
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
		enterRule(_localctx, 54, RULE_prefixExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0)) {
				{
				{
				setState(336);
				prefixOperation();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
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
		enterRule(_localctx, 56, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			atomicExpression();
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(345);
					postfixOperation();
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 58, RULE_atomicExpression);
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				match(T__1);
				setState(352);
				expression();
				setState(353);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				lambda();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(356);
				ifExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(357);
				sizeof();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(358);
				identifier();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(359);
				inlineC();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(360);
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

	public static class AssignmentOperationContext extends ParserRuleContext {
		public AssignmentOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperation; }
	}

	public final AssignmentOperationContext assignmentOperation() throws RecognitionException {
		AssignmentOperationContext _localctx = new AssignmentOperationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_assignmentOperation);
		try {
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				match(T__10);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(366);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 5);
				{
				setState(367);
				match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 6);
				{
				setState(368);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 7);
				{
				setState(369);
				match(T__24);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 8);
				{
				setState(370);
				match(T__25);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 9);
				{
				setState(371);
				match(T__26);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 10);
				{
				setState(372);
				match(T__27);
				setState(373);
				match(T__27);
				setState(374);
				match(T__10);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 11);
				{
				setState(375);
				match(T__28);
				setState(376);
				match(T__28);
				setState(377);
				match(T__10);
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

	public static class DisjunctionOperationContext extends ParserRuleContext {
		public DisjunctionOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctionOperation; }
	}

	public final DisjunctionOperationContext disjunctionOperation() throws RecognitionException {
		DisjunctionOperationContext _localctx = new DisjunctionOperationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_disjunctionOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
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

	public static class ConjunctionOperationContext extends ParserRuleContext {
		public ConjunctionOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunctionOperation; }
	}

	public final ConjunctionOperationContext conjunctionOperation() throws RecognitionException {
		ConjunctionOperationContext _localctx = new ConjunctionOperationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_conjunctionOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_la = _input.LA(1);
			if ( !(_la==T__32 || _la==T__33) ) {
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
		enterRule(_localctx, 66, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__35) ) {
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
		enterRule(_localctx, 68, RULE_comparisonOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__36) | (1L << T__37))) != 0)) ) {
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

	public static class BitshiftOperationContext extends ParserRuleContext {
		public BitshiftOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitshiftOperation; }
	}

	public final BitshiftOperationContext bitshiftOperation() throws RecognitionException {
		BitshiftOperationContext _localctx = new BitshiftOperationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_bitshiftOperation);
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				match(T__28);
				setState(389);
				match(T__28);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				match(T__27);
				setState(391);
				match(T__27);
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

	public static class AdditiveOperationContext extends ParserRuleContext {
		public AdditiveOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOperation; }
	}

	public final AdditiveOperationContext additiveOperation() throws RecognitionException {
		AdditiveOperationContext _localctx = new AdditiveOperationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_additiveOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !(_la==T__38 || _la==T__39) ) {
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
		enterRule(_localctx, 74, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
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
		enterRule(_localctx, 76, RULE_prefixOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0)) ) {
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
		public DotCallContext dotCall() {
			return getRuleContext(DotCallContext.class,0);
		}
		public PostfixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOperation; }
	}

	public final PostfixOperationContext postfixOperation() throws RecognitionException {
		PostfixOperationContext _localctx = new PostfixOperationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_postfixOperation);
		try {
			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				match(T__43);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				match(T__44);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(402);
				postfixCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				memberAccess();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				dotCall();
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

	public static class PostfixCallContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public PostfixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixCall; }
	}

	public final PostfixCallContext postfixCall() throws RecognitionException {
		PostfixCallContext _localctx = new PostfixCallContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_postfixCall);
		try {
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				match(T__1);
				setState(408);
				expressionList();
				setState(409);
				match(T__2);
				setState(411);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(410);
					lambda();
					}
					break;
				}
				}
				break;
			case T__0:
			case T__7:
			case T__47:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				lambda();
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

	public static class MemberAccessContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(T__12);
			setState(417);
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

	public static class DotCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public DotCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotCall; }
	}

	public final DotCallContext dotCall() throws RecognitionException {
		DotCallContext _localctx = new DotCallContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_dotCall);
		try {
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				match(T__12);
				setState(420);
				identifier();
				setState(421);
				match(T__1);
				setState(422);
				expressionList();
				setState(423);
				match(T__2);
				setState(425);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(424);
					lambda();
					}
					break;
				}
				}
				break;
			case T__0:
			case T__7:
			case T__47:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				lambda();
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

	public static class LambdaContext extends ParserRuleContext {
		public TypeContext returnType;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FnArgumentListContext fnArgumentList() {
			return getRuleContext(FnArgumentListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public NameListContext nameList() {
			return getRuleContext(NameListContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_lambda);
		int _la;
		try {
			setState(451);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				match(T__0);
				setState(435);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(431);
					match(T__1);
					setState(432);
					fnArgumentList();
					setState(433);
					match(T__2);
					}
					break;
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(437);
					match(T__3);
					setState(438);
					((LambdaContext)_localctx).returnType = type();
					}
				}

				setState(441);
				block();
				}
				break;
			case T__7:
			case T__47:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__47 || _la==NAME) {
					{
					setState(442);
					nameList();
					setState(443);
					match(T__47);
					}
				}

				setState(447);
				match(T__7);
				setState(448);
				statementBlock();
				setState(449);
				match(T__8);
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
		enterRule(_localctx, 88, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(T__14);
			setState(454);
			match(T__1);
			setState(455);
			((IfExpressionContext)_localctx).test = expression();
			setState(456);
			match(T__2);
			setState(457);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(458);
			match(T__15);
			setState(459);
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
		enterRule(_localctx, 90, RULE_sizeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(T__48);
			setState(462);
			match(T__1);
			setState(463);
			type();
			setState(464);
			match(T__2);
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
		enterRule(_localctx, 92, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
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
		enterRule(_localctx, 94, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(468);
				((TypeContext)_localctx).isConst = match(T__49);
				}
			}

			setState(471);
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
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_ltype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(474);
				match(NAME);
				}
				break;
			case T__1:
				{
				setState(475);
				match(T__1);
				setState(476);
				((LtypeContext)_localctx).args = typeList();
				setState(477);
				match(T__2);
				setState(478);
				match(T__47);
				setState(479);
				((LtypeContext)_localctx).returnType = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(487);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LtypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ltype);
					setState(483);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(484);
					((LtypeContext)_localctx).ptr = match(T__40);
					}
					} 
				}
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		enterRule(_localctx, 98, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(490);
					expression();
					setState(491);
					match(T__5);
					}
					} 
				}
				setState(497);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__14) | (1L << T__38) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << NAME))) != 0)) {
				{
				setState(498);
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
		enterRule(_localctx, 100, RULE_nameList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(501);
					match(NAME);
					setState(502);
					match(T__5);
					}
					} 
				}
				setState(507);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(508);
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
		enterRule(_localctx, 102, RULE_typeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(511);
					type();
					setState(512);
					match(T__5);
					}
					} 
				}
				setState(518);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			setState(521);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__50:
				{
				setState(519);
				((TypeListContext)_localctx).vararg = match(T__50);
				}
				break;
			case T__1:
			case T__49:
			case NAME:
				{
				setState(520);
				type();
				}
				break;
			case T__2:
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

	public static class StatementBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__38) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__51) | (1L << T__52) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << NAME))) != 0)) {
				{
				{
				setState(523);
				statement();
				}
				}
				setState(528);
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

	public static class BlockContext extends ParserRuleContext {
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_block);
		try {
			setState(536);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(529);
				match(T__7);
				setState(530);
				statementBlock();
				setState(531);
				match(T__8);
				setState(533);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(532);
					semi();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				statement();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QuartzParser.NAME, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
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

	public static class InlineCContext extends ParserRuleContext {
		public TerminalNode INLINE_C() { return getToken(QuartzParser.INLINE_C, 0); }
		public InlineCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineC; }
	}

	public final InlineCContext inlineC() throws RecognitionException {
		InlineCContext _localctx = new InlineCContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_inlineC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
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
		enterRule(_localctx, 112, RULE_varDeclarationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			_la = _input.LA(1);
			if ( !(_la==T__51 || _la==T__52) ) {
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
		enterRule(_localctx, 114, RULE_semi);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(545); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(544);
					match(T__53);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(547); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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
		case 48:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3B\u0228\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\7\2x\n\2"+
		"\f\2\16\2{\13\2\3\2\7\2~\n\2\f\2\16\2\u0081\13\2\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\u0088\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0091\n\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009f\n\6\3\6\5\6\u00a2\n\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\7\b\u00ab\n\b\f\b\16\b\u00ae\13\b\3\b\5\b\u00b1"+
		"\n\b\3\t\5\t\u00b4\n\t\3\t\3\t\3\t\3\t\7\t\u00ba\n\t\f\t\16\t\u00bd\13"+
		"\t\3\t\3\t\5\t\u00c1\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00c8\n\n\3\13\5\13\u00cb"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d2\n\13\3\f\3\f\3\f\5\f\u00d7\n"+
		"\f\3\r\3\r\7\r\u00db\n\r\f\r\16\r\u00de\13\r\3\r\3\r\3\16\3\16\5\16\u00e4"+
		"\n\16\3\16\3\16\5\16\u00e8\n\16\3\16\3\16\5\16\u00ec\n\16\3\16\3\16\5"+
		"\16\u00f0\n\16\3\16\3\16\5\16\u00f4\n\16\3\16\3\16\5\16\u00f8\n\16\3\16"+
		"\3\16\5\16\u00fc\n\16\3\16\3\16\5\16\u0100\n\16\5\16\u0102\n\16\3\17\3"+
		"\17\3\17\3\17\5\17\u0108\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0117\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u0127\n\25\3\26\3\26\3\26"+
		"\3\26\5\26\u012d\n\26\3\27\3\27\3\27\3\27\5\27\u0133\n\27\3\30\3\30\3"+
		"\30\3\30\5\30\u0139\n\30\3\31\3\31\3\31\3\31\5\31\u013f\n\31\3\32\3\32"+
		"\3\32\3\32\5\32\u0145\n\32\3\33\3\33\3\33\3\33\5\33\u014b\n\33\3\34\3"+
		"\34\3\34\3\34\5\34\u0151\n\34\3\35\7\35\u0154\n\35\f\35\16\35\u0157\13"+
		"\35\3\35\3\35\3\36\3\36\7\36\u015d\n\36\f\36\16\36\u0160\13\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u016c\n\37\3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u017d\n \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3%\3%\5%\u018b\n%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\5)\u0198"+
		"\n)\3*\3*\3*\3*\5*\u019e\n*\3*\5*\u01a1\n*\3+\3+\3+\3,\3,\3,\3,\3,\3,"+
		"\5,\u01ac\n,\3,\5,\u01af\n,\3-\3-\3-\3-\3-\5-\u01b6\n-\3-\3-\5-\u01ba"+
		"\n-\3-\3-\3-\3-\5-\u01c0\n-\3-\3-\3-\3-\5-\u01c6\n-\3.\3.\3.\3.\3.\3."+
		"\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\61\5\61\u01d8\n\61\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u01e4\n\62\3\62\3\62\7\62\u01e8"+
		"\n\62\f\62\16\62\u01eb\13\62\3\63\3\63\3\63\7\63\u01f0\n\63\f\63\16\63"+
		"\u01f3\13\63\3\63\5\63\u01f6\n\63\3\64\3\64\7\64\u01fa\n\64\f\64\16\64"+
		"\u01fd\13\64\3\64\5\64\u0200\n\64\3\65\3\65\3\65\7\65\u0205\n\65\f\65"+
		"\16\65\u0208\13\65\3\65\3\65\5\65\u020c\n\65\3\66\7\66\u020f\n\66\f\66"+
		"\16\66\u0212\13\66\3\67\3\67\3\67\3\67\5\67\u0218\n\67\3\67\5\67\u021b"+
		"\n\67\38\38\39\39\3:\3:\3;\6;\u0224\n;\r;\16;\u0225\3;\2\3b<\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprt\2\13\3\2 \"\3\2#$\3\2%&\4\2\36\37\'(\3\2)*\3\2+-\4\2)*.\61"+
		"\3\2:=\3\2\66\67\u0246\2y\3\2\2\2\4\u0087\3\2\2\2\6\u0089\3\2\2\2\b\u0094"+
		"\3\2\2\2\n\u0097\3\2\2\2\f\u00a3\3\2\2\2\16\u00ac\3\2\2\2\20\u00b3\3\2"+
		"\2\2\22\u00c2\3\2\2\2\24\u00ca\3\2\2\2\26\u00d3\3\2\2\2\30\u00dc\3\2\2"+
		"\2\32\u0101\3\2\2\2\34\u0103\3\2\2\2\36\u010c\3\2\2\2 \u010f\3\2\2\2\""+
		"\u0118\3\2\2\2$\u011e\3\2\2\2&\u0120\3\2\2\2(\u0122\3\2\2\2*\u0128\3\2"+
		"\2\2,\u012e\3\2\2\2.\u0134\3\2\2\2\60\u013a\3\2\2\2\62\u0140\3\2\2\2\64"+
		"\u0146\3\2\2\2\66\u014c\3\2\2\28\u0155\3\2\2\2:\u015a\3\2\2\2<\u016b\3"+
		"\2\2\2>\u017c\3\2\2\2@\u017e\3\2\2\2B\u0180\3\2\2\2D\u0182\3\2\2\2F\u0184"+
		"\3\2\2\2H\u018a\3\2\2\2J\u018c\3\2\2\2L\u018e\3\2\2\2N\u0190\3\2\2\2P"+
		"\u0197\3\2\2\2R\u01a0\3\2\2\2T\u01a2\3\2\2\2V\u01ae\3\2\2\2X\u01c5\3\2"+
		"\2\2Z\u01c7\3\2\2\2\\\u01cf\3\2\2\2^\u01d4\3\2\2\2`\u01d7\3\2\2\2b\u01e3"+
		"\3\2\2\2d\u01f1\3\2\2\2f\u01fb\3\2\2\2h\u0206\3\2\2\2j\u0210\3\2\2\2l"+
		"\u021a\3\2\2\2n\u021c\3\2\2\2p\u021e\3\2\2\2r\u0220\3\2\2\2t\u0223\3\2"+
		"\2\2vx\5\26\f\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\177\3\2\2\2{"+
		"y\3\2\2\2|~\5\4\3\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\3\3\2\2\2\u0081\177\3\2\2\2\u0082\u0088\5\6\4\2\u0083\u0088"+
		"\5\b\5\2\u0084\u0088\5\20\t\2\u0085\u0088\5\24\13\2\u0086\u0088\5p9\2"+
		"\u0087\u0082\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0086\3\2\2\2\u0088\5\3\2\2\2\u0089\u008a\7\3\2\2\u008a"+
		"\u008b\7?\2\2\u008b\u008c\7\4\2\2\u008c\u008d\5\16\b\2\u008d\u0090\7\5"+
		"\2\2\u008e\u008f\7\6\2\2\u008f\u0091\5`\61\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\5l\67\2\u0093\7\3\2\2\2"+
		"\u0094\u0095\7\7\2\2\u0095\u0096\5\n\6\2\u0096\t\3\2\2\2\u0097\u0098\7"+
		"\3\2\2\u0098\u0099\7?\2\2\u0099\u009a\7\4\2\2\u009a\u009b\5h\65\2\u009b"+
		"\u009e\7\5\2\2\u009c\u009d\7\6\2\2\u009d\u009f\5`\61\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u00a2\5t;\2\u00a1\u00a0"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\13\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4"+
		"\u00a5\7\6\2\2\u00a5\u00a6\5`\61\2\u00a6\r\3\2\2\2\u00a7\u00a8\5\f\7\2"+
		"\u00a8\u00a9\7\b\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b1\5\f\7\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\17\3\2\2\2\u00b2\u00b4\7\7\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\t\2\2\u00b6\u00b7\7?\2\2\u00b7"+
		"\u00bb\7\n\2\2\u00b8\u00ba\5\22\n\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3"+
		"\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00c0\7\13\2\2\u00bf\u00c1\5t;\2\u00c0\u00bf\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\21\3\2\2\2\u00c2\u00c3\5r:\2\u00c3\u00c4"+
		"\7?\2\2\u00c4\u00c5\7\6\2\2\u00c5\u00c7\5`\61\2\u00c6\u00c8\5t;\2\u00c7"+
		"\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\23\3\2\2\2\u00c9\u00cb\7\7\2"+
		"\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd"+
		"\7\f\2\2\u00cd\u00ce\7?\2\2\u00ce\u00cf\7\r\2\2\u00cf\u00d1\5`\61\2\u00d0"+
		"\u00d2\5t;\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\25\3\2\2\2"+
		"\u00d3\u00d4\7\16\2\2\u00d4\u00d6\5\30\r\2\u00d5\u00d7\5t;\2\u00d6\u00d5"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\27\3\2\2\2\u00d8\u00d9\7?\2\2\u00d9"+
		"\u00db\7\17\2\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3"+
		"\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00e0\7?\2\2\u00e0\31\3\2\2\2\u00e1\u00e3\5p9\2\u00e2\u00e4\5t;\2\u00e3"+
		"\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u0102\3\2\2\2\u00e5\u00e7\5\36"+
		"\20\2\u00e6\u00e8\5t;\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u0102\3\2\2\2\u00e9\u00eb\5\34\17\2\u00ea\u00ec\5t;\2\u00eb\u00ea\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u0102\3\2\2\2\u00ed\u00ef\5 \21\2\u00ee"+
		"\u00f0\5t;\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u0102\3\2\2"+
		"\2\u00f1\u00f3\5\"\22\2\u00f2\u00f4\5t;\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u0102\3\2\2\2\u00f5\u00f7\5$\23\2\u00f6\u00f8\5t;\2\u00f7"+
		"\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u0102\3\2\2\2\u00f9\u00fb\5&"+
		"\24\2\u00fa\u00fc\5t;\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u0102\3\2\2\2\u00fd\u00ff\5(\25\2\u00fe\u0100\5t;\2\u00ff\u00fe\3\2\2"+
		"\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00e1\3\2\2\2\u0101\u00e5"+
		"\3\2\2\2\u0101\u00e9\3\2\2\2\u0101\u00ed\3\2\2\2\u0101\u00f1\3\2\2\2\u0101"+
		"\u00f5\3\2\2\2\u0101\u00f9\3\2\2\2\u0101\u00fd\3\2\2\2\u0102\33\3\2\2"+
		"\2\u0103\u0104\5r:\2\u0104\u0107\5n8\2\u0105\u0106\7\6\2\2\u0106\u0108"+
		"\5`\61\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\7\r\2\2\u010a\u010b\5(\25\2\u010b\35\3\2\2\2\u010c\u010d\7\20\2"+
		"\2\u010d\u010e\5(\25\2\u010e\37\3\2\2\2\u010f\u0110\7\21\2\2\u0110\u0111"+
		"\7\4\2\2\u0111\u0112\5(\25\2\u0112\u0113\7\5\2\2\u0113\u0116\5l\67\2\u0114"+
		"\u0115\7\22\2\2\u0115\u0117\5l\67\2\u0116\u0114\3\2\2\2\u0116\u0117\3"+
		"\2\2\2\u0117!\3\2\2\2\u0118\u0119\7\23\2\2\u0119\u011a\7\4\2\2\u011a\u011b"+
		"\5(\25\2\u011b\u011c\7\5\2\2\u011c\u011d\5l\67\2\u011d#\3\2\2\2\u011e"+
		"\u011f\7\24\2\2\u011f%\3\2\2\2\u0120\u0121\7\25\2\2\u0121\'\3\2\2\2\u0122"+
		"\u0126\5*\26\2\u0123\u0124\5> \2\u0124\u0125\5(\25\2\u0125\u0127\3\2\2"+
		"\2\u0126\u0123\3\2\2\2\u0126\u0127\3\2\2\2\u0127)\3\2\2\2\u0128\u012c"+
		"\5,\27\2\u0129\u012a\5@!\2\u012a\u012b\5*\26\2\u012b\u012d\3\2\2\2\u012c"+
		"\u0129\3\2\2\2\u012c\u012d\3\2\2\2\u012d+\3\2\2\2\u012e\u0132\5.\30\2"+
		"\u012f\u0130\5B\"\2\u0130\u0131\5,\27\2\u0131\u0133\3\2\2\2\u0132\u012f"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133-\3\2\2\2\u0134\u0138\5\60\31\2\u0135"+
		"\u0136\5D#\2\u0136\u0137\5.\30\2\u0137\u0139\3\2\2\2\u0138\u0135\3\2\2"+
		"\2\u0138\u0139\3\2\2\2\u0139/\3\2\2\2\u013a\u013e\5\62\32\2\u013b\u013c"+
		"\5F$\2\u013c\u013d\5\60\31\2\u013d\u013f\3\2\2\2\u013e\u013b\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\61\3\2\2\2\u0140\u0144\5\64\33\2\u0141\u0142\5H%"+
		"\2\u0142\u0143\5\62\32\2\u0143\u0145\3\2\2\2\u0144\u0141\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145\63\3\2\2\2\u0146\u014a\5\66\34\2\u0147\u0148\5J&"+
		"\2\u0148\u0149\5\64\33\2\u0149\u014b\3\2\2\2\u014a\u0147\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\65\3\2\2\2\u014c\u0150\58\35\2\u014d\u014e\5L\'\2"+
		"\u014e\u014f\5\66\34\2\u014f\u0151\3\2\2\2\u0150\u014d\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\67\3\2\2\2\u0152\u0154\5N(\2\u0153\u0152\3\2\2\2\u0154"+
		"\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2"+
		"\2\2\u0157\u0155\3\2\2\2\u0158\u0159\5:\36\2\u01599\3\2\2\2\u015a\u015e"+
		"\5<\37\2\u015b\u015d\5P)\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f;\3\2\2\2\u0160\u015e\3\2\2\2"+
		"\u0161\u0162\7\4\2\2\u0162\u0163\5(\25\2\u0163\u0164\7\5\2\2\u0164\u016c"+
		"\3\2\2\2\u0165\u016c\5X-\2\u0166\u016c\5Z.\2\u0167\u016c\5\\/\2\u0168"+
		"\u016c\5n8\2\u0169\u016c\5p9\2\u016a\u016c\5^\60\2\u016b\u0161\3\2\2\2"+
		"\u016b\u0165\3\2\2\2\u016b\u0166\3\2\2\2\u016b\u0167\3\2\2\2\u016b\u0168"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016a\3\2\2\2\u016c=\3\2\2\2\u016d"+
		"\u017d\7\r\2\2\u016e\u017d\7\26\2\2\u016f\u017d\7\27\2\2\u0170\u017d\7"+
		"\30\2\2\u0171\u017d\7\31\2\2\u0172\u017d\7\32\2\2\u0173\u017d\7\33\2\2"+
		"\u0174\u017d\7\34\2\2\u0175\u017d\7\35\2\2\u0176\u0177\7\36\2\2\u0177"+
		"\u0178\7\36\2\2\u0178\u017d\7\r\2\2\u0179\u017a\7\37\2\2\u017a\u017b\7"+
		"\37\2\2\u017b\u017d\7\r\2\2\u017c\u016d\3\2\2\2\u017c\u016e\3\2\2\2\u017c"+
		"\u016f\3\2\2\2\u017c\u0170\3\2\2\2\u017c\u0171\3\2\2\2\u017c\u0172\3\2"+
		"\2\2\u017c\u0173\3\2\2\2\u017c\u0174\3\2\2\2\u017c\u0175\3\2\2\2\u017c"+
		"\u0176\3\2\2\2\u017c\u0179\3\2\2\2\u017d?\3\2\2\2\u017e\u017f\t\2\2\2"+
		"\u017fA\3\2\2\2\u0180\u0181\t\3\2\2\u0181C\3\2\2\2\u0182\u0183\t\4\2\2"+
		"\u0183E\3\2\2\2\u0184\u0185\t\5\2\2\u0185G\3\2\2\2\u0186\u0187\7\37\2"+
		"\2\u0187\u018b\7\37\2\2\u0188\u0189\7\36\2\2\u0189\u018b\7\36\2\2\u018a"+
		"\u0186\3\2\2\2\u018a\u0188\3\2\2\2\u018bI\3\2\2\2\u018c\u018d\t\6\2\2"+
		"\u018dK\3\2\2\2\u018e\u018f\t\7\2\2\u018fM\3\2\2\2\u0190\u0191\t\b\2\2"+
		"\u0191O\3\2\2\2\u0192\u0198\7.\2\2\u0193\u0198\7/\2\2\u0194\u0198\5R*"+
		"\2\u0195\u0198\5T+\2\u0196\u0198\5V,\2\u0197\u0192\3\2\2\2\u0197\u0193"+
		"\3\2\2\2\u0197\u0194\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198"+
		"Q\3\2\2\2\u0199\u019a\7\4\2\2\u019a\u019b\5d\63\2\u019b\u019d\7\5\2\2"+
		"\u019c\u019e\5X-\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a1"+
		"\3\2\2\2\u019f\u01a1\5X-\2\u01a0\u0199\3\2\2\2\u01a0\u019f\3\2\2\2\u01a1"+
		"S\3\2\2\2\u01a2\u01a3\7\17\2\2\u01a3\u01a4\7?\2\2\u01a4U\3\2\2\2\u01a5"+
		"\u01a6\7\17\2\2\u01a6\u01a7\5n8\2\u01a7\u01a8\7\4\2\2\u01a8\u01a9\5d\63"+
		"\2\u01a9\u01ab\7\5\2\2\u01aa\u01ac\5X-\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac"+
		"\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01af\5X-\2\u01ae\u01a5\3\2\2\2\u01ae"+
		"\u01ad\3\2\2\2\u01afW\3\2\2\2\u01b0\u01b5\7\3\2\2\u01b1\u01b2\7\4\2\2"+
		"\u01b2\u01b3\5\16\b\2\u01b3\u01b4\7\5\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b1"+
		"\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b8\7\6\2\2\u01b8"+
		"\u01ba\5`\61\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bb\u01c6\5l\67\2\u01bc\u01bd\5f\64\2\u01bd\u01be\7\62\2\2\u01be"+
		"\u01c0\3\2\2\2\u01bf\u01bc\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\u01c2\7\n\2\2\u01c2\u01c3\5j\66\2\u01c3\u01c4\7\13\2\2\u01c4"+
		"\u01c6\3\2\2\2\u01c5\u01b0\3\2\2\2\u01c5\u01bf\3\2\2\2\u01c6Y\3\2\2\2"+
		"\u01c7\u01c8\7\21\2\2\u01c8\u01c9\7\4\2\2\u01c9\u01ca\5(\25\2\u01ca\u01cb"+
		"\7\5\2\2\u01cb\u01cc\5(\25\2\u01cc\u01cd\7\22\2\2\u01cd\u01ce\5(\25\2"+
		"\u01ce[\3\2\2\2\u01cf\u01d0\7\63\2\2\u01d0\u01d1\7\4\2\2\u01d1\u01d2\5"+
		"`\61\2\u01d2\u01d3\7\5\2\2\u01d3]\3\2\2\2\u01d4\u01d5\t\t\2\2\u01d5_\3"+
		"\2\2\2\u01d6\u01d8\7\64\2\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01da\5b\62\2\u01daa\3\2\2\2\u01db\u01dc\b\62\1\2"+
		"\u01dc\u01e4\7?\2\2\u01dd\u01de\7\4\2\2\u01de\u01df\5h\65\2\u01df\u01e0"+
		"\7\5\2\2\u01e0\u01e1\7\62\2\2\u01e1\u01e2\5`\61\2\u01e2\u01e4\3\2\2\2"+
		"\u01e3\u01db\3\2\2\2\u01e3\u01dd\3\2\2\2\u01e4\u01e9\3\2\2\2\u01e5\u01e6"+
		"\f\4\2\2\u01e6\u01e8\7+\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9"+
		"\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01eac\3\2\2\2\u01eb\u01e9\3\2\2\2"+
		"\u01ec\u01ed\5(\25\2\u01ed\u01ee\7\b\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01ec"+
		"\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2"+
		"\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f6\5(\25\2\u01f5\u01f4\3\2"+
		"\2\2\u01f5\u01f6\3\2\2\2\u01f6e\3\2\2\2\u01f7\u01f8\7?\2\2\u01f8\u01fa"+
		"\7\b\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb"+
		"\u01fc\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u0200\7?"+
		"\2\2\u01ff\u01fe\3\2\2\2\u01ff\u0200\3\2\2\2\u0200g\3\2\2\2\u0201\u0202"+
		"\5`\61\2\u0202\u0203\7\b\2\2\u0203\u0205\3\2\2\2\u0204\u0201\3\2\2\2\u0205"+
		"\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u020b\3\2"+
		"\2\2\u0208\u0206\3\2\2\2\u0209\u020c\7\65\2\2\u020a\u020c\5`\61\2\u020b"+
		"\u0209\3\2\2\2\u020b\u020a\3\2\2\2\u020b\u020c\3\2\2\2\u020ci\3\2\2\2"+
		"\u020d\u020f\5\32\16\2\u020e\u020d\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e"+
		"\3\2\2\2\u0210\u0211\3\2\2\2\u0211k\3\2\2\2\u0212\u0210\3\2\2\2\u0213"+
		"\u0214\7\n\2\2\u0214\u0215\5j\66\2\u0215\u0217\7\13\2\2\u0216\u0218\5"+
		"t;\2\u0217\u0216\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021b\3\2\2\2\u0219"+
		"\u021b\5\32\16\2\u021a\u0213\3\2\2\2\u021a\u0219\3\2\2\2\u021bm\3\2\2"+
		"\2\u021c\u021d\7?\2\2\u021do\3\2\2\2\u021e\u021f\7>\2\2\u021fq\3\2\2\2"+
		"\u0220\u0221\t\n\2\2\u0221s\3\2\2\2\u0222\u0224\78\2\2\u0223\u0222\3\2"+
		"\2\2\u0224\u0225\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226"+
		"u\3\2\2\2@y\177\u0087\u0090\u009e\u00a1\u00ac\u00b0\u00b3\u00bb\u00c0"+
		"\u00c7\u00ca\u00d1\u00d6\u00dc\u00e3\u00e7\u00eb\u00ef\u00f3\u00f7\u00fb"+
		"\u00ff\u0101\u0107\u0116\u0126\u012c\u0132\u0138\u013e\u0144\u014a\u0150"+
		"\u0155\u015e\u016b\u017c\u018a\u0197\u019d\u01a0\u01ab\u01ae\u01b5\u01b9"+
		"\u01bf\u01c5\u01d7\u01e3\u01e9\u01f1\u01f5\u01fb\u01ff\u0206\u020b\u0210"+
		"\u0217\u021a\u0225";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}