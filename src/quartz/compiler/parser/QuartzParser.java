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
		DMOD=46, STRING=47, CHAR=48, INT=49, DOUBLE=50, INLINE_C=51, IDENTIFIER=52, 
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
		RULE_type = 41, RULE_ltype = 42, RULE_expressionList = 43, RULE_identifierList = 44, 
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
		"identifierList", "typeList", "block", "identifier", "inlineC", "varDeclarationType", 
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
		"CHAR", "INT", "DOUBLE", "INLINE_C", "IDENTIFIER", "BLOCK_COMMENT", "LINE_COMMENT", 
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FnArgumentListContext fnArgumentList() {
			return getRuleContext(FnArgumentListContext.class,0);
		}
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
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
				identifierList();
				setState(124);
				match(T__2);
				}
			}

			setState(128);
			identifier();
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
			identifier();
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
			identifier();
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
			if (_la==IDENTIFIER) {
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
			case IDENTIFIER:
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
			identifier();
			setState(181);
			match(T__10);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__42 || _la==T__43) {
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
			match(T__11);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
			setState(192);
			varDeclarationType();
			setState(193);
			identifier();
			setState(194);
			match(T__5);
			setState(195);
			type();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(199);
				((TypealiasDeclarationContext)_localctx).extern = match(T__6);
				}
			}

			setState(202);
			match(T__12);
			setState(203);
			identifier();
			setState(204);
			match(T__8);
			setState(205);
			type();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
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
		enterRule(_localctx, 22, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__13);
			setState(210);
			packageList();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
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
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
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
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					identifier();
					setState(215);
					match(T__14);
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(222);
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
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				inlineC();
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(225);
					semi();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				returnStatement();
				setState(230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(229);
					semi();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				varDeclaration();
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(233);
					semi();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(236);
				ifStatement();
				setState(238);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(237);
					semi();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				whileLoop();
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(241);
					semi();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(244);
				expression();
				setState(246);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(245);
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
			setState(250);
			varDeclarationType();
			setState(251);
			identifier();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(252);
				match(T__5);
				setState(253);
				type();
				}
			}

			setState(256);
			match(T__8);
			setState(257);
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
			setState(259);
			match(T__15);
			setState(260);
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
			setState(262);
			match(T__16);
			setState(263);
			match(T__3);
			setState(264);
			expression();
			setState(265);
			match(T__4);
			setState(266);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(267);
				match(T__17);
				setState(268);
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
			setState(271);
			match(T__18);
			setState(272);
			match(T__3);
			setState(273);
			expression();
			setState(274);
			match(T__4);
			setState(275);
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
			setState(277);
			disjunction();
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(278);
				assignmentOperator();
				setState(279);
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
			setState(283);
			conjunction();
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(284);
				match(T__19);
				setState(285);
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
			setState(288);
			equalityComparison();
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(289);
				match(T__20);
				setState(290);
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
			setState(293);
			comparison();
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(294);
				equalityOperation();
				setState(295);
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
			setState(299);
			additiveExpression();
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(300);
				comparisonOperation();
				setState(301);
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
			setState(305);
			multiplicativeExpression();
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(306);
				additiveOperation();
				setState(307);
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
			setState(311);
			prefixExpression();
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(312);
				multiplicativeOperation();
				setState(313);
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
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) {
				{
				{
				setState(317);
				prefixOperation();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(323);
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
			setState(325);
			atomicExpression();
			setState(329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(326);
					postfixOperation();
					}
					} 
				}
				setState(331);
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
		enterRule(_localctx, 54, RULE_atomicExpression);
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				match(T__3);
				setState(333);
				expression();
				setState(334);
				match(T__4);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				lambda();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(337);
				ifExpression();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 4);
				{
				setState(338);
				sizeof();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(339);
				identifier();
				}
				break;
			case INLINE_C:
				enterOuterAlt(_localctx, 6);
				{
				setState(340);
				inlineC();
				}
				break;
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(341);
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
			setState(344);
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
			setState(346);
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
			setState(348);
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
			setState(350);
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
			setState(352);
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
			setState(354);
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
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				match(T__36);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(358);
				postfixCall();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(359);
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
			setState(362);
			match(T__3);
			setState(363);
			expressionList();
			setState(364);
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
			setState(366);
			match(T__14);
			setState(367);
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
			setState(369);
			match(T__0);
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(370);
				match(T__3);
				setState(371);
				fnArgumentList();
				setState(372);
				match(T__4);
				}
				break;
			}
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(376);
				match(T__5);
				setState(377);
				((LambdaContext)_localctx).returnType = type();
				}
			}

			setState(380);
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
			setState(382);
			match(T__16);
			setState(383);
			match(T__3);
			setState(384);
			((IfExpressionContext)_localctx).test = expression();
			setState(385);
			match(T__4);
			setState(386);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(387);
			match(T__17);
			setState(388);
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
			setState(390);
			match(T__38);
			setState(391);
			match(T__3);
			setState(392);
			type();
			setState(393);
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
			setState(395);
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
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39) {
				{
				setState(397);
				((TypeContext)_localctx).isConst = match(T__39);
				}
			}

			setState(400);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(403);
				identifier();
				}
				break;
			case T__3:
				{
				setState(404);
				match(T__3);
				setState(405);
				((LtypeContext)_localctx).args = typeList();
				setState(406);
				match(T__4);
				setState(407);
				match(T__40);
				setState(408);
				((LtypeContext)_localctx).returnType = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(416);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LtypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ltype);
					setState(412);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(413);
					((LtypeContext)_localctx).ptr = match(T__32);
					}
					} 
				}
				setState(418);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
			setState(424);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(419);
					expression();
					setState(420);
					match(T__7);
					}
					} 
				}
				setState(426);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__16) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(427);
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
		enterRule(_localctx, 88, RULE_identifierList);
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
					identifier();
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
			if (_la==IDENTIFIER) {
				{
				setState(438);
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
			setState(446);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(441);
					type();
					setState(442);
					match(T__7);
					}
					} 
				}
				setState(448);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(451);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__41:
				{
				setState(449);
				((TypeListContext)_localctx).vararg = match(T__41);
				}
				break;
			case T__3:
			case T__39:
			case IDENTIFIER:
				{
				setState(450);
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
			setState(465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				match(T__10);
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__42) | (1L << T__43) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(454);
					statement();
					}
					}
					setState(459);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(460);
				match(T__11);
				setState(462);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(461);
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
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
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
			setState(467);
			match(IDENTIFIER);
			setState(472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(468);
				match(T__1);
				setState(469);
				typeList();
				setState(470);
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
			setState(474);
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
			setState(476);
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
			setState(479); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(478);
					match(T__44);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(481); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u01e6\4\2\t\2\4"+
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
		"\t\5\t\u00b1\n\t\3\n\5\n\u00b4\n\n\3\n\3\n\3\n\3\n\7\n\u00ba\n\n\f\n\16"+
		"\n\u00bd\13\n\3\n\3\n\5\n\u00c1\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u00c8"+
		"\n\13\3\f\5\f\u00cb\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d2\n\f\3\r\3\r\3\r"+
		"\5\r\u00d7\n\r\3\16\3\16\3\16\7\16\u00dc\n\16\f\16\16\16\u00df\13\16\3"+
		"\16\3\16\3\17\3\17\5\17\u00e5\n\17\3\17\3\17\5\17\u00e9\n\17\3\17\3\17"+
		"\5\17\u00ed\n\17\3\17\3\17\5\17\u00f1\n\17\3\17\3\17\5\17\u00f5\n\17\3"+
		"\17\3\17\5\17\u00f9\n\17\5\17\u00fb\n\17\3\20\3\20\3\20\3\20\5\20\u0101"+
		"\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u0110\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24"+
		"\u011c\n\24\3\25\3\25\3\25\5\25\u0121\n\25\3\26\3\26\3\26\5\26\u0126\n"+
		"\26\3\27\3\27\3\27\3\27\5\27\u012c\n\27\3\30\3\30\3\30\3\30\5\30\u0132"+
		"\n\30\3\31\3\31\3\31\3\31\5\31\u0138\n\31\3\32\3\32\3\32\3\32\5\32\u013e"+
		"\n\32\3\33\7\33\u0141\n\33\f\33\16\33\u0144\13\33\3\33\3\33\3\34\3\34"+
		"\7\34\u014a\n\34\f\34\16\34\u014d\13\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u0159\n\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3$\3$\5$\u016b\n$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\5\'\u0179\n\'\3\'\3\'\5\'\u017d\n\'\3\'\3\'\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3+\5+\u0191\n+\3+\3+\3,\3,\3,\3,\3,\3,\3"+
		",\3,\5,\u019d\n,\3,\3,\7,\u01a1\n,\f,\16,\u01a4\13,\3-\3-\3-\7-\u01a9"+
		"\n-\f-\16-\u01ac\13-\3-\5-\u01af\n-\3.\3.\3.\7.\u01b4\n.\f.\16.\u01b7"+
		"\13.\3.\5.\u01ba\n.\3/\3/\3/\7/\u01bf\n/\f/\16/\u01c2\13/\3/\3/\5/\u01c6"+
		"\n/\3\60\3\60\7\60\u01ca\n\60\f\60\16\60\u01cd\13\60\3\60\3\60\5\60\u01d1"+
		"\n\60\3\60\5\60\u01d4\n\60\3\61\3\61\3\61\3\61\3\61\5\61\u01db\n\61\3"+
		"\62\3\62\3\63\3\63\3\64\6\64\u01e2\n\64\r\64\16\64\u01e3\3\64\2\3V\65"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPRTVXZ\\^`bdf\2\n\4\2\13\13\30\34\3\2\35\36\4\2\4\5\37 \3\2!\"\3\2"+
		"#%\4\2\"\"&(\3\2\61\64\3\2-.\u01f8\2k\3\2\2\2\4y\3\2\2\2\6{\3\2\2\2\b"+
		"\u008c\3\2\2\2\n\u008f\3\2\2\2\f\u009b\3\2\2\2\16\u00a4\3\2\2\2\20\u00b0"+
		"\3\2\2\2\22\u00b3\3\2\2\2\24\u00c2\3\2\2\2\26\u00ca\3\2\2\2\30\u00d3\3"+
		"\2\2\2\32\u00dd\3\2\2\2\34\u00fa\3\2\2\2\36\u00fc\3\2\2\2 \u0105\3\2\2"+
		"\2\"\u0108\3\2\2\2$\u0111\3\2\2\2&\u0117\3\2\2\2(\u011d\3\2\2\2*\u0122"+
		"\3\2\2\2,\u0127\3\2\2\2.\u012d\3\2\2\2\60\u0133\3\2\2\2\62\u0139\3\2\2"+
		"\2\64\u0142\3\2\2\2\66\u0147\3\2\2\28\u0158\3\2\2\2:\u015a\3\2\2\2<\u015c"+
		"\3\2\2\2>\u015e\3\2\2\2@\u0160\3\2\2\2B\u0162\3\2\2\2D\u0164\3\2\2\2F"+
		"\u016a\3\2\2\2H\u016c\3\2\2\2J\u0170\3\2\2\2L\u0173\3\2\2\2N\u0180\3\2"+
		"\2\2P\u0188\3\2\2\2R\u018d\3\2\2\2T\u0190\3\2\2\2V\u019c\3\2\2\2X\u01aa"+
		"\3\2\2\2Z\u01b5\3\2\2\2\\\u01c0\3\2\2\2^\u01d3\3\2\2\2`\u01d5\3\2\2\2"+
		"b\u01dc\3\2\2\2d\u01de\3\2\2\2f\u01e1\3\2\2\2hj\5\30\r\2ih\3\2\2\2jm\3"+
		"\2\2\2ki\3\2\2\2kl\3\2\2\2lq\3\2\2\2mk\3\2\2\2np\5\4\3\2on\3\2\2\2ps\3"+
		"\2\2\2qo\3\2\2\2qr\3\2\2\2r\3\3\2\2\2sq\3\2\2\2tz\5\6\4\2uz\5\b\5\2vz"+
		"\5\22\n\2wz\5\26\f\2xz\5b\62\2yt\3\2\2\2yu\3\2\2\2yv\3\2\2\2yw\3\2\2\2"+
		"yx\3\2\2\2z\5\3\2\2\2{\u0080\7\3\2\2|}\7\4\2\2}~\5Z.\2~\177\7\5\2\2\177"+
		"\u0081\3\2\2\2\u0080|\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2"+
		"\u0082\u0083\5`\61\2\u0083\u0084\7\6\2\2\u0084\u0085\5\16\b\2\u0085\u0088"+
		"\7\7\2\2\u0086\u0087\7\b\2\2\u0087\u0089\5T+\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\5\20\t\2\u008b\7\3\2\2"+
		"\2\u008c\u008d\7\t\2\2\u008d\u008e\5\n\6\2\u008e\t\3\2\2\2\u008f\u0090"+
		"\7\3\2\2\u0090\u0091\5`\61\2\u0091\u0092\7\6\2\2\u0092\u0093\5\\/\2\u0093"+
		"\u0096\7\7\2\2\u0094\u0095\7\b\2\2\u0095\u0097\5T+\2\u0096\u0094\3\2\2"+
		"\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u009a\5f\64\2\u0099\u0098"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\13\3\2\2\2\u009b\u009c\5`\61\2\u009c"+
		"\u009d\7\b\2\2\u009d\u009e\5T+\2\u009e\r\3\2\2\2\u009f\u00a0\5\f\7\2\u00a0"+
		"\u00a1\7\n\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a6\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00a9\5\f\7\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\17\3\2\2\2\u00aa\u00b1\5^\60\2\u00ab\u00ac\7\13\2\2\u00ac\u00ae"+
		"\5&\24\2\u00ad\u00af\5f\64\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1\21\3\2\2"+
		"\2\u00b2\u00b4\7\t\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\u00b6\7\f\2\2\u00b6\u00b7\5`\61\2\u00b7\u00bb\7\r\2\2\u00b8"+
		"\u00ba\5\24\13\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3"+
		"\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c0\7\16\2\2\u00bf\u00c1\5f\64\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\23\3\2\2\2\u00c2\u00c3\5d\63\2\u00c3\u00c4\5`\61\2\u00c4"+
		"\u00c5\7\b\2\2\u00c5\u00c7\5T+\2\u00c6\u00c8\5f\64\2\u00c7\u00c6\3\2\2"+
		"\2\u00c7\u00c8\3\2\2\2\u00c8\25\3\2\2\2\u00c9\u00cb\7\t\2\2\u00ca\u00c9"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\7\17\2\2"+
		"\u00cd\u00ce\5`\61\2\u00ce\u00cf\7\13\2\2\u00cf\u00d1\5T+\2\u00d0\u00d2"+
		"\5f\64\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\27\3\2\2\2\u00d3"+
		"\u00d4\7\20\2\2\u00d4\u00d6\5\32\16\2\u00d5\u00d7\5f\64\2\u00d6\u00d5"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\31\3\2\2\2\u00d8\u00d9\5`\61\2\u00d9"+
		"\u00da\7\21\2\2\u00da\u00dc\3\2\2\2\u00db\u00d8\3\2\2\2\u00dc\u00df\3"+
		"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\u00e1\5`\61\2\u00e1\33\3\2\2\2\u00e2\u00e4\5b\62"+
		"\2\u00e3\u00e5\5f\64\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00fb"+
		"\3\2\2\2\u00e6\u00e8\5 \21\2\u00e7\u00e9\5f\64\2\u00e8\u00e7\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00fb\3\2\2\2\u00ea\u00ec\5\36\20\2\u00eb\u00ed\5"+
		"f\64\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00fb\3\2\2\2\u00ee"+
		"\u00f0\5\"\22\2\u00ef\u00f1\5f\64\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3"+
		"\2\2\2\u00f1\u00fb\3\2\2\2\u00f2\u00f4\5$\23\2\u00f3\u00f5\5f\64\2\u00f4"+
		"\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00fb\3\2\2\2\u00f6\u00f8\5&"+
		"\24\2\u00f7\u00f9\5f\64\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fb\3\2\2\2\u00fa\u00e2\3\2\2\2\u00fa\u00e6\3\2\2\2\u00fa\u00ea\3\2"+
		"\2\2\u00fa\u00ee\3\2\2\2\u00fa\u00f2\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fb"+
		"\35\3\2\2\2\u00fc\u00fd\5d\63\2\u00fd\u0100\5`\61\2\u00fe\u00ff\7\b\2"+
		"\2\u00ff\u0101\5T+\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0103\7\13\2\2\u0103\u0104\5&\24\2\u0104\37\3\2\2\2\u0105"+
		"\u0106\7\22\2\2\u0106\u0107\5&\24\2\u0107!\3\2\2\2\u0108\u0109\7\23\2"+
		"\2\u0109\u010a\7\6\2\2\u010a\u010b\5&\24\2\u010b\u010c\7\7\2\2\u010c\u010f"+
		"\5^\60\2\u010d\u010e\7\24\2\2\u010e\u0110\5^\60\2\u010f\u010d\3\2\2\2"+
		"\u010f\u0110\3\2\2\2\u0110#\3\2\2\2\u0111\u0112\7\25\2\2\u0112\u0113\7"+
		"\6\2\2\u0113\u0114\5&\24\2\u0114\u0115\7\7\2\2\u0115\u0116\5^\60\2\u0116"+
		"%\3\2\2\2\u0117\u011b\5(\25\2\u0118\u0119\5:\36\2\u0119\u011a\5&\24\2"+
		"\u011a\u011c\3\2\2\2\u011b\u0118\3\2\2\2\u011b\u011c\3\2\2\2\u011c\'\3"+
		"\2\2\2\u011d\u0120\5*\26\2\u011e\u011f\7\26\2\2\u011f\u0121\5(\25\2\u0120"+
		"\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121)\3\2\2\2\u0122\u0125\5,\27\2"+
		"\u0123\u0124\7\27\2\2\u0124\u0126\5*\26\2\u0125\u0123\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126+\3\2\2\2\u0127\u012b\5.\30\2\u0128\u0129\5<\37\2\u0129"+
		"\u012a\5,\27\2\u012a\u012c\3\2\2\2\u012b\u0128\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c-\3\2\2\2\u012d\u0131\5\60\31\2\u012e\u012f\5> \2\u012f\u0130"+
		"\5.\30\2\u0130\u0132\3\2\2\2\u0131\u012e\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"/\3\2\2\2\u0133\u0137\5\62\32\2\u0134\u0135\5@!\2\u0135\u0136\5\60\31"+
		"\2\u0136\u0138\3\2\2\2\u0137\u0134\3\2\2\2\u0137\u0138\3\2\2\2\u0138\61"+
		"\3\2\2\2\u0139\u013d\5\64\33\2\u013a\u013b\5B\"\2\u013b\u013c\5\62\32"+
		"\2\u013c\u013e\3\2\2\2\u013d\u013a\3\2\2\2\u013d\u013e\3\2\2\2\u013e\63"+
		"\3\2\2\2\u013f\u0141\5D#\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0145\u0146\5\66\34\2\u0146\65\3\2\2\2\u0147\u014b\58\35\2\u0148"+
		"\u014a\5F$\2\u0149\u0148\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2"+
		"\2\u014b\u014c\3\2\2\2\u014c\67\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f"+
		"\7\6\2\2\u014f\u0150\5&\24\2\u0150\u0151\7\7\2\2\u0151\u0159\3\2\2\2\u0152"+
		"\u0159\5L\'\2\u0153\u0159\5N(\2\u0154\u0159\5P)\2\u0155\u0159\5`\61\2"+
		"\u0156\u0159\5b\62\2\u0157\u0159\5R*\2\u0158\u014e\3\2\2\2\u0158\u0152"+
		"\3\2\2\2\u0158\u0153\3\2\2\2\u0158\u0154\3\2\2\2\u0158\u0155\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0158\u0157\3\2\2\2\u01599\3\2\2\2\u015a\u015b\t\2\2\2"+
		"\u015b;\3\2\2\2\u015c\u015d\t\3\2\2\u015d=\3\2\2\2\u015e\u015f\t\4\2\2"+
		"\u015f?\3\2\2\2\u0160\u0161\t\5\2\2\u0161A\3\2\2\2\u0162\u0163\t\6\2\2"+
		"\u0163C\3\2\2\2\u0164\u0165\t\7\2\2\u0165E\3\2\2\2\u0166\u016b\7&\2\2"+
		"\u0167\u016b\7\'\2\2\u0168\u016b\5H%\2\u0169\u016b\5J&\2\u016a\u0166\3"+
		"\2\2\2\u016a\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b"+
		"G\3\2\2\2\u016c\u016d\7\6\2\2\u016d\u016e\5X-\2\u016e\u016f\7\7\2\2\u016f"+
		"I\3\2\2\2\u0170\u0171\7\21\2\2\u0171\u0172\5`\61\2\u0172K\3\2\2\2\u0173"+
		"\u0178\7\3\2\2\u0174\u0175\7\6\2\2\u0175\u0176\5\16\b\2\u0176\u0177\7"+
		"\7\2\2\u0177\u0179\3\2\2\2\u0178\u0174\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017c\3\2\2\2\u017a\u017b\7\b\2\2\u017b\u017d\5T+\2\u017c\u017a\3\2\2"+
		"\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\5\20\t\2\u017f"+
		"M\3\2\2\2\u0180\u0181\7\23\2\2\u0181\u0182\7\6\2\2\u0182\u0183\5&\24\2"+
		"\u0183\u0184\7\7\2\2\u0184\u0185\5&\24\2\u0185\u0186\7\24\2\2\u0186\u0187"+
		"\5&\24\2\u0187O\3\2\2\2\u0188\u0189\7)\2\2\u0189\u018a\7\6\2\2\u018a\u018b"+
		"\5T+\2\u018b\u018c\7\7\2\2\u018cQ\3\2\2\2\u018d\u018e\t\b\2\2\u018eS\3"+
		"\2\2\2\u018f\u0191\7*\2\2\u0190\u018f\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0193\5V,\2\u0193U\3\2\2\2\u0194\u0195\b,\1\2\u0195"+
		"\u019d\5`\61\2\u0196\u0197\7\6\2\2\u0197\u0198\5\\/\2\u0198\u0199\7\7"+
		"\2\2\u0199\u019a\7+\2\2\u019a\u019b\5T+\2\u019b\u019d\3\2\2\2\u019c\u0194"+
		"\3\2\2\2\u019c\u0196\3\2\2\2\u019d\u01a2\3\2\2\2\u019e\u019f\f\4\2\2\u019f"+
		"\u01a1\7#\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2"+
		"\2\2\u01a2\u01a3\3\2\2\2\u01a3W\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6"+
		"\5&\24\2\u01a6\u01a7\7\n\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01a5\3\2\2\2\u01a9"+
		"\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ae\3\2"+
		"\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01af\5&\24\2\u01ae\u01ad\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01afY\3\2\2\2\u01b0\u01b1\5`\61\2\u01b1\u01b2\7\n\2\2"+
		"\u01b2\u01b4\3\2\2\2\u01b3\u01b0\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3"+
		"\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8"+
		"\u01ba\5`\61\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba[\3\2\2\2"+
		"\u01bb\u01bc\5T+\2\u01bc\u01bd\7\n\2\2\u01bd\u01bf\3\2\2\2\u01be\u01bb"+
		"\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1"+
		"\u01c5\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\7,\2\2\u01c4\u01c6\5T+"+
		"\2\u01c5\u01c3\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6]"+
		"\3\2\2\2\u01c7\u01cb\7\r\2\2\u01c8\u01ca\5\34\17\2\u01c9\u01c8\3\2\2\2"+
		"\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ce"+
		"\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01d0\7\16\2\2\u01cf\u01d1\5f\64\2"+
		"\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d4"+
		"\5\34\17\2\u01d3\u01c7\3\2\2\2\u01d3\u01d2\3\2\2\2\u01d4_\3\2\2\2\u01d5"+
		"\u01da\7\66\2\2\u01d6\u01d7\7\4\2\2\u01d7\u01d8\5\\/\2\u01d8\u01d9\7\5"+
		"\2\2\u01d9\u01db\3\2\2\2\u01da\u01d6\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"a\3\2\2\2\u01dc\u01dd\7\65\2\2\u01ddc\3\2\2\2\u01de\u01df\t\t\2\2\u01df"+
		"e\3\2\2\2\u01e0\u01e2\7/\2\2\u01e1\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4g\3\2\2\29kqy\u0080\u0088\u0096"+
		"\u0099\u00a4\u00a8\u00ae\u00b0\u00b3\u00bb\u00c0\u00c7\u00ca\u00d1\u00d6"+
		"\u00dd\u00e4\u00e8\u00ec\u00f0\u00f4\u00f8\u00fa\u0100\u010f\u011b\u0120"+
		"\u0125\u012b\u0131\u0137\u013d\u0142\u014b\u0158\u016a\u0178\u017c\u0190"+
		"\u019c\u01a2\u01aa\u01ae\u01b5\u01b9\u01c0\u01c5\u01cb\u01d0\u01d3\u01da"+
		"\u01e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}