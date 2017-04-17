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
		T__45=46, T__46=47, DMOD=48, STRING=49, CHAR=50, INT=51, DOUBLE=52, INLINE_C=53, 
		IDENTIFIER=54, BLOCK_COMMENT=55, LINE_COMMENT=56, WHITESPACE=57;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_functionDeclaration = 2, 
		RULE_signatureDefinition = 3, RULE_fnArgument = 4, RULE_fnArgumentList = 5, 
		RULE_fnBlock = 6, RULE_structDeclaration = 7, RULE_structMember = 8, RULE_typealiasDeclaration = 9, 
		RULE_destructorDeclaration = 10, RULE_importDeclaration = 11, RULE_packageList = 12, 
		RULE_statement = 13, RULE_varDeclaration = 14, RULE_returnStatement = 15, 
		RULE_ifStatement = 16, RULE_whileLoop = 17, RULE_delete = 18, RULE_typeswitch = 19, 
		RULE_typeswitchBranch = 20, RULE_expression = 21, RULE_disjunction = 22, 
		RULE_conjunction = 23, RULE_equalityComparison = 24, RULE_comparison = 25, 
		RULE_additiveExpression = 26, RULE_multiplicativeExpression = 27, RULE_prefixExpression = 28, 
		RULE_postfixExpression = 29, RULE_atomicExpression = 30, RULE_assignmentOperator = 31, 
		RULE_equalityOperation = 32, RULE_comparisonOperation = 33, RULE_additiveOperation = 34, 
		RULE_multiplicativeOperation = 35, RULE_prefixOperation = 36, RULE_postfixOperation = 37, 
		RULE_postfixCall = 38, RULE_memberAccess = 39, RULE_ifExpression = 40, 
		RULE_sizeof = 41, RULE_literal = 42, RULE_type = 43, RULE_expressionList = 44, 
		RULE_identifierList = 45, RULE_typeList = 46, RULE_block = 47, RULE_identifier = 48, 
		RULE_inlineC = 49, RULE_varDeclarationType = 50, RULE_semi = 51;
	public static final String[] ruleNames = {
		"program", "declaration", "functionDeclaration", "signatureDefinition", 
		"fnArgument", "fnArgumentList", "fnBlock", "structDeclaration", "structMember", 
		"typealiasDeclaration", "destructorDeclaration", "importDeclaration", 
		"packageList", "statement", "varDeclaration", "returnStatement", "ifStatement", 
		"whileLoop", "delete", "typeswitch", "typeswitchBranch", "expression", 
		"disjunction", "conjunction", "equalityComparison", "comparison", "additiveExpression", 
		"multiplicativeExpression", "prefixExpression", "postfixExpression", "atomicExpression", 
		"assignmentOperator", "equalityOperation", "comparisonOperation", "additiveOperation", 
		"multiplicativeOperation", "prefixOperation", "postfixOperation", "postfixCall", 
		"memberAccess", "ifExpression", "sizeof", "literal", "type", "expressionList", 
		"identifierList", "typeList", "block", "identifier", "inlineC", "varDeclarationType", 
		"semi"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'<'", "'>'", "'.'", "'('", "')'", "':'", "'extern'", "','", 
		"'='", "'struct'", "'{'", "'}'", "'typealias'", "'destructor'", "'import'", 
		"'return'", "'if'", "'else'", "'while'", "'delete'", "'typeswitch'", "'||'", 
		"'&&'", "'+='", "'-='", "'*='", "'/='", "'%='", "'=='", "'!='", "'>='", 
		"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'!'", "'sizeof'", 
		"'->'", "'...'", "'var'", "'val'", "';'", "'%%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", "IDENTIFIER", "BLOCK_COMMENT", 
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
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(104);
				importDeclaration();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << INLINE_C))) != 0)) {
				{
				{
				setState(110);
				declaration();
				}
				}
				setState(115);
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
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public TypealiasDeclarationContext typealiasDeclaration() {
			return getRuleContext(TypealiasDeclarationContext.class,0);
		}
		public DestructorDeclarationContext destructorDeclaration() {
			return getRuleContext(DestructorDeclarationContext.class,0);
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
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				functionDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				structDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				typealiasDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				destructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
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
		public Token receiver;
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
		public SignatureDefinitionContext signatureDefinition() {
			return getRuleContext(SignatureDefinitionContext.class,0);
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
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(T__0);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(124);
					match(T__1);
					setState(125);
					identifierList();
					setState(126);
					match(T__2);
					}
				}

				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(130);
					((FunctionDeclarationContext)_localctx).receiver = match(T__3);
					}
				}

				setState(133);
				identifier();
				setState(134);
				match(T__4);
				setState(135);
				fnArgumentList();
				setState(136);
				match(T__5);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(137);
					match(T__6);
					setState(138);
					((FunctionDeclarationContext)_localctx).returnType = type(0);
					}
				}

				setState(141);
				fnBlock();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(T__7);
				setState(144);
				signatureDefinition();
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
		enterRule(_localctx, 6, RULE_signatureDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__0);
			setState(148);
			identifier();
			setState(149);
			match(T__4);
			setState(150);
			typeList();
			setState(151);
			match(T__5);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(152);
				match(T__6);
				setState(153);
				((SignatureDefinitionContext)_localctx).returnType = type(0);
				}
			}

			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(156);
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
		enterRule(_localctx, 8, RULE_fnArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(159);
			identifier();
			setState(160);
			match(T__6);
			setState(161);
			type(0);
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
		enterRule(_localctx, 10, RULE_fnArgumentList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(163);
					fnArgument();
					setState(164);
					match(T__8);
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(171);
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
		enterRule(_localctx, 12, RULE_fnBlock);
		int _la;
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__11:
			case T__16:
			case T__17:
			case T__19:
			case T__20:
			case T__21:
			case T__34:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__44:
			case T__45:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				block();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(T__9);
				setState(176);
				expression();
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__46) {
					{
					setState(177);
					semi();
					}
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
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
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
		enterRule(_localctx, 14, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(182);
				((StructDeclarationContext)_localctx).extern = match(T__7);
				}
			}

			setState(185);
			match(T__10);
			setState(186);
			identifier();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(187);
				match(T__1);
				setState(188);
				identifierList();
				setState(189);
				match(T__2);
				}
			}

			setState(193);
			match(T__11);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__44 || _la==T__45) {
				{
				{
				setState(194);
				structMember();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
			match(T__12);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(201);
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
		enterRule(_localctx, 16, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			varDeclarationType();
			setState(205);
			identifier();
			setState(206);
			match(T__6);
			setState(207);
			type(0);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(208);
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
		enterRule(_localctx, 18, RULE_typealiasDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(211);
				((TypealiasDeclarationContext)_localctx).extern = match(T__7);
				}
			}

			setState(214);
			match(T__13);
			setState(215);
			identifier();
			setState(216);
			match(T__9);
			setState(217);
			type(0);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(218);
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

	public static class DestructorDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public DestructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructorDeclaration; }
	}

	public final DestructorDeclarationContext destructorDeclaration() throws RecognitionException {
		DestructorDeclarationContext _localctx = new DestructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_destructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__14);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(222);
				match(T__1);
				setState(223);
				identifierList();
				setState(224);
				match(T__2);
				}
			}

			setState(228);
			type(0);
			setState(229);
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
			setState(231);
			match(T__15);
			setState(232);
			packageList();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(233);
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
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(236);
					identifier();
					setState(237);
					match(T__3);
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(244);
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
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public TypeswitchContext typeswitch() {
			return getRuleContext(TypeswitchContext.class,0);
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
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				inlineC();
				setState(248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(247);
					semi();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				returnStatement();
				setState(251);
				semi();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				varDeclaration();
				setState(254);
				semi();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				ifStatement();
				setState(258);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(257);
					semi();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				whileLoop();
				setState(262);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(261);
					semi();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(264);
				delete();
				setState(266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(265);
					semi();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(268);
				typeswitch();
				setState(270);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(269);
					semi();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(272);
				expression();
				setState(273);
				semi();
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
			setState(277);
			varDeclarationType();
			setState(278);
			identifier();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(279);
				match(T__6);
				setState(280);
				type(0);
				}
			}

			setState(283);
			match(T__9);
			setState(284);
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
			setState(286);
			match(T__16);
			setState(287);
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
			setState(289);
			match(T__17);
			setState(290);
			match(T__4);
			setState(291);
			expression();
			setState(292);
			match(T__5);
			setState(293);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(294);
				match(T__18);
				setState(295);
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
			setState(298);
			match(T__19);
			setState(299);
			match(T__4);
			setState(300);
			expression();
			setState(301);
			match(T__5);
			setState(302);
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

	public static class DeleteContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_delete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(T__20);
			setState(305);
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

	public static class TypeswitchContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TypeswitchBranchContext> typeswitchBranch() {
			return getRuleContexts(TypeswitchBranchContext.class);
		}
		public TypeswitchBranchContext typeswitchBranch(int i) {
			return getRuleContext(TypeswitchBranchContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeswitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeswitch; }
	}

	public final TypeswitchContext typeswitch() throws RecognitionException {
		TypeswitchContext _localctx = new TypeswitchContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeswitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(T__21);
			setState(308);
			match(T__4);
			setState(309);
			identifier();
			setState(310);
			match(T__5);
			setState(311);
			match(T__11);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==IDENTIFIER) {
				{
				{
				setState(312);
				typeswitchBranch();
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(318);
				match(T__18);
				setState(319);
				block();
				}
			}

			setState(322);
			match(T__12);
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

	public static class TypeswitchBranchContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeswitchBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeswitchBranch; }
	}

	public final TypeswitchBranchContext typeswitchBranch() throws RecognitionException {
		TypeswitchBranchContext _localctx = new TypeswitchBranchContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeswitchBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			type(0);
			setState(325);
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
		enterRule(_localctx, 42, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			disjunction();
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(328);
				assignmentOperator();
				setState(329);
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
		enterRule(_localctx, 44, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			conjunction();
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(334);
				match(T__22);
				setState(335);
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
		enterRule(_localctx, 46, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			equalityComparison();
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(339);
				match(T__23);
				setState(340);
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
		enterRule(_localctx, 48, RULE_equalityComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			comparison();
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(344);
				equalityOperation();
				setState(345);
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
		enterRule(_localctx, 50, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			additiveExpression();
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(350);
				comparisonOperation();
				setState(351);
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
		enterRule(_localctx, 52, RULE_additiveExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			multiplicativeExpression();
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(356);
				additiveOperation();
				setState(357);
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
		enterRule(_localctx, 54, RULE_multiplicativeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			prefixExpression();
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(362);
				multiplicativeOperation();
				setState(363);
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
		enterRule(_localctx, 56, RULE_prefixExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) {
				{
				{
				setState(367);
				prefixOperation();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(373);
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
		enterRule(_localctx, 58, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			atomicExpression();
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(376);
					postfixOperation();
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		enterRule(_localctx, 60, RULE_atomicExpression);
		try {
			setState(391);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(T__4);
				setState(383);
				expression();
				setState(384);
				match(T__5);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				ifExpression();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 3);
				{
				setState(387);
				sizeof();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(388);
				identifier();
				}
				break;
			case INLINE_C:
				enterOuterAlt(_localctx, 5);
				{
				setState(389);
				inlineC();
				}
				break;
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 6);
				{
				setState(390);
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
		enterRule(_localctx, 62, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			_la = _input.LA(1);
			if ( !(_la==T__29 || _la==T__30) ) {
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
		enterRule(_localctx, 66, RULE_comparisonOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__31) | (1L << T__32))) != 0)) ) {
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
		enterRule(_localctx, 68, RULE_additiveOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			_la = _input.LA(1);
			if ( !(_la==T__33 || _la==T__34) ) {
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
		enterRule(_localctx, 70, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
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
		enterRule(_localctx, 72, RULE_prefixOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_postfixOperation);
		try {
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				match(T__38);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 2);
				{
				setState(406);
				match(T__39);
				}
				break;
			case T__1:
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(407);
				postfixCall();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(408);
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
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public PostfixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixCall; }
	}

	public final PostfixCallContext postfixCall() throws RecognitionException {
		PostfixCallContext _localctx = new PostfixCallContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_postfixCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(411);
				match(T__1);
				setState(412);
				typeList();
				setState(413);
				match(T__2);
				}
			}

			setState(417);
			match(T__4);
			setState(418);
			expressionList();
			setState(419);
			match(T__5);
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
		enterRule(_localctx, 78, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__3);
			setState(422);
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
		enterRule(_localctx, 80, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(T__17);
			setState(425);
			match(T__4);
			setState(426);
			((IfExpressionContext)_localctx).test = expression();
			setState(427);
			match(T__5);
			setState(428);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(429);
			match(T__18);
			setState(430);
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
		enterRule(_localctx, 82, RULE_sizeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(T__41);
			setState(433);
			match(T__4);
			setState(434);
			type(0);
			setState(435);
			match(T__5);
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
		enterRule(_localctx, 84, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(440);
				identifier();
				setState(445);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(441);
					match(T__1);
					setState(442);
					typeList();
					setState(443);
					match(T__2);
					}
					break;
				}
				}
				break;
			case T__4:
				{
				setState(447);
				match(T__4);
				setState(448);
				((TypeContext)_localctx).args = typeList();
				setState(449);
				match(T__5);
				setState(450);
				match(T__42);
				setState(451);
				((TypeContext)_localctx).returnType = type(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(459);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(455);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(456);
					((TypeContext)_localctx).ptr = match(T__35);
					}
					} 
				}
				setState(461);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
		enterRule(_localctx, 88, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(462);
					expression();
					setState(463);
					match(T__8);
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__17) | (1L << T__34) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(470);
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
		enterRule(_localctx, 90, RULE_identifierList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(473);
					identifier();
					setState(474);
					match(T__8);
					}
					} 
				}
				setState(480);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(481);
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
		enterRule(_localctx, 92, RULE_typeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(484);
					type(0);
					setState(485);
					match(T__8);
					}
					} 
				}
				setState(491);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			setState(494);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__43:
				{
				setState(492);
				((TypeListContext)_localctx).vararg = match(T__43);
				}
				break;
			case T__4:
			case IDENTIFIER:
				{
				setState(493);
				type(0);
				}
				break;
			case T__2:
			case T__5:
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
		enterRule(_localctx, 94, RULE_block);
		int _la;
		try {
			setState(508);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(496);
				match(T__11);
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__34) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__44) | (1L << T__45) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(497);
					statement();
					}
					}
					setState(502);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(503);
				match(T__12);
				setState(505);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(504);
					semi();
					}
					break;
				}
				}
				break;
			case T__4:
			case T__16:
			case T__17:
			case T__19:
			case T__20:
			case T__21:
			case T__34:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__44:
			case T__45:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
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
		enterRule(_localctx, 96, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
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
		enterRule(_localctx, 98, RULE_inlineC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
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
		enterRule(_localctx, 100, RULE_varDeclarationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_la = _input.LA(1);
			if ( !(_la==T__44 || _la==T__45) ) {
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
		enterRule(_localctx, 102, RULE_semi);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(517); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(516);
					match(T__46);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(519); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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
		case 43:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3;\u020c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\3\2\7\2l\n\2\f\2\16\2o\13\2\3\2\7\2r\n\2\f\2\16\2u\13\2"+
		"\3\3\3\3\3\3\3\3\3\3\5\3|\n\3\3\4\3\4\3\4\3\4\3\4\5\4\u0083\n\4\3\4\5"+
		"\4\u0086\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008e\n\4\3\4\3\4\3\4\3\4\5\4"+
		"\u0094\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u009d\n\5\3\5\5\5\u00a0\n\5"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00a9\n\7\f\7\16\7\u00ac\13\7\3\7\5\7"+
		"\u00af\n\7\3\b\3\b\3\b\3\b\5\b\u00b5\n\b\5\b\u00b7\n\b\3\t\5\t\u00ba\n"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c2\n\t\3\t\3\t\7\t\u00c6\n\t\f\t\16"+
		"\t\u00c9\13\t\3\t\3\t\5\t\u00cd\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00d4\n\n"+
		"\3\13\5\13\u00d7\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00de\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00e5\n\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u00ed\n\r\3\16"+
		"\3\16\3\16\7\16\u00f2\n\16\f\16\16\16\u00f5\13\16\3\16\3\16\3\17\3\17"+
		"\5\17\u00fb\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0105\n"+
		"\17\3\17\3\17\5\17\u0109\n\17\3\17\3\17\5\17\u010d\n\17\3\17\3\17\5\17"+
		"\u0111\n\17\3\17\3\17\3\17\5\17\u0116\n\17\3\20\3\20\3\20\3\20\5\20\u011c"+
		"\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u012b\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u013c\n\25\f\25\16\25\u013f\13\25\3\25\3\25"+
		"\5\25\u0143\n\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u014e"+
		"\n\27\3\30\3\30\3\30\5\30\u0153\n\30\3\31\3\31\3\31\5\31\u0158\n\31\3"+
		"\32\3\32\3\32\3\32\5\32\u015e\n\32\3\33\3\33\3\33\3\33\5\33\u0164\n\33"+
		"\3\34\3\34\3\34\3\34\5\34\u016a\n\34\3\35\3\35\3\35\3\35\5\35\u0170\n"+
		"\35\3\36\7\36\u0173\n\36\f\36\16\36\u0176\13\36\3\36\3\36\3\37\3\37\7"+
		"\37\u017c\n\37\f\37\16\37\u017f\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u018a"+
		"\n \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\5\'\u019c\n"+
		"\'\3(\3(\3(\3(\5(\u01a2\n(\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\5-\u01c0\n-\3-\3-\3-\3-\3-\3"+
		"-\5-\u01c8\n-\3-\3-\7-\u01cc\n-\f-\16-\u01cf\13-\3.\3.\3.\7.\u01d4\n."+
		"\f.\16.\u01d7\13.\3.\5.\u01da\n.\3/\3/\3/\7/\u01df\n/\f/\16/\u01e2\13"+
		"/\3/\5/\u01e5\n/\3\60\3\60\3\60\7\60\u01ea\n\60\f\60\16\60\u01ed\13\60"+
		"\3\60\3\60\5\60\u01f1\n\60\3\61\3\61\7\61\u01f5\n\61\f\61\16\61\u01f8"+
		"\13\61\3\61\3\61\5\61\u01fc\n\61\3\61\5\61\u01ff\n\61\3\62\3\62\3\63\3"+
		"\63\3\64\3\64\3\65\6\65\u0208\n\65\r\65\16\65\u0209\3\65\2\3X\66\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`bdfh\2\n\4\2\f\f\33\37\3\2 !\4\2\4\5\"#\3\2$%\3\2&(\4\2%%)+\3\2"+
		"\63\66\3\2/\60\u0221\2m\3\2\2\2\4{\3\2\2\2\6\u0093\3\2\2\2\b\u0095\3\2"+
		"\2\2\n\u00a1\3\2\2\2\f\u00aa\3\2\2\2\16\u00b6\3\2\2\2\20\u00b9\3\2\2\2"+
		"\22\u00ce\3\2\2\2\24\u00d6\3\2\2\2\26\u00df\3\2\2\2\30\u00e9\3\2\2\2\32"+
		"\u00f3\3\2\2\2\34\u0115\3\2\2\2\36\u0117\3\2\2\2 \u0120\3\2\2\2\"\u0123"+
		"\3\2\2\2$\u012c\3\2\2\2&\u0132\3\2\2\2(\u0135\3\2\2\2*\u0146\3\2\2\2,"+
		"\u0149\3\2\2\2.\u014f\3\2\2\2\60\u0154\3\2\2\2\62\u0159\3\2\2\2\64\u015f"+
		"\3\2\2\2\66\u0165\3\2\2\28\u016b\3\2\2\2:\u0174\3\2\2\2<\u0179\3\2\2\2"+
		">\u0189\3\2\2\2@\u018b\3\2\2\2B\u018d\3\2\2\2D\u018f\3\2\2\2F\u0191\3"+
		"\2\2\2H\u0193\3\2\2\2J\u0195\3\2\2\2L\u019b\3\2\2\2N\u01a1\3\2\2\2P\u01a7"+
		"\3\2\2\2R\u01aa\3\2\2\2T\u01b2\3\2\2\2V\u01b7\3\2\2\2X\u01c7\3\2\2\2Z"+
		"\u01d5\3\2\2\2\\\u01e0\3\2\2\2^\u01eb\3\2\2\2`\u01fe\3\2\2\2b\u0200\3"+
		"\2\2\2d\u0202\3\2\2\2f\u0204\3\2\2\2h\u0207\3\2\2\2jl\5\30\r\2kj\3\2\2"+
		"\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2ns\3\2\2\2om\3\2\2\2pr\5\4\3\2qp\3\2\2"+
		"\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\3\3\2\2\2us\3\2\2\2v|\5\6\4\2w|\5\20"+
		"\t\2x|\5\24\13\2y|\5\26\f\2z|\5d\63\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2{y"+
		"\3\2\2\2{z\3\2\2\2|\5\3\2\2\2}\u0082\7\3\2\2~\177\7\4\2\2\177\u0080\5"+
		"\\/\2\u0080\u0081\7\5\2\2\u0081\u0083\3\2\2\2\u0082~\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0086\7\6\2\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\5b\62\2\u0088\u0089\7\7"+
		"\2\2\u0089\u008a\5\f\7\2\u008a\u008d\7\b\2\2\u008b\u008c\7\t\2\2\u008c"+
		"\u008e\5X-\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2"+
		"\2\u008f\u0090\5\16\b\2\u0090\u0094\3\2\2\2\u0091\u0092\7\n\2\2\u0092"+
		"\u0094\5\b\5\2\u0093}\3\2\2\2\u0093\u0091\3\2\2\2\u0094\7\3\2\2\2\u0095"+
		"\u0096\7\3\2\2\u0096\u0097\5b\62\2\u0097\u0098\7\7\2\2\u0098\u0099\5^"+
		"\60\2\u0099\u009c\7\b\2\2\u009a\u009b\7\t\2\2\u009b\u009d\5X-\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u00a0\5h"+
		"\65\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\t\3\2\2\2\u00a1\u00a2"+
		"\5b\62\2\u00a2\u00a3\7\t\2\2\u00a3\u00a4\5X-\2\u00a4\13\3\2\2\2\u00a5"+
		"\u00a6\5\n\6\2\u00a6\u00a7\7\13\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a5\3"+
		"\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00af\5\n\6\2\u00ae\u00ad\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\r\3\2\2\2\u00b0\u00b7\5`\61\2\u00b1\u00b2"+
		"\7\f\2\2\u00b2\u00b4\5,\27\2\u00b3\u00b5\5h\65\2\u00b4\u00b3\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b1\3\2"+
		"\2\2\u00b7\17\3\2\2\2\u00b8\u00ba\7\n\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\r\2\2\u00bc\u00c1\5b\62\2\u00bd"+
		"\u00be\7\4\2\2\u00be\u00bf\5\\/\2\u00bf\u00c0\7\5\2\2\u00c0\u00c2\3\2"+
		"\2\2\u00c1\u00bd\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c7\7\16\2\2\u00c4\u00c6\5\22\n\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cc\7\17\2\2\u00cb\u00cd\5h\65\2\u00cc\u00cb\3"+
		"\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\21\3\2\2\2\u00ce\u00cf\5f\64\2\u00cf"+
		"\u00d0\5b\62\2\u00d0\u00d1\7\t\2\2\u00d1\u00d3\5X-\2\u00d2\u00d4\5h\65"+
		"\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\23\3\2\2\2\u00d5\u00d7"+
		"\7\n\2\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\7\20\2\2\u00d9\u00da\5b\62\2\u00da\u00db\7\f\2\2\u00db\u00dd\5"+
		"X-\2\u00dc\u00de\5h\65\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\25\3\2\2\2\u00df\u00e4\7\21\2\2\u00e0\u00e1\7\4\2\2\u00e1\u00e2\5\\/"+
		"\2\u00e2\u00e3\7\5\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\5X-\2\u00e7\u00e8\5\16\b\2\u00e8"+
		"\27\3\2\2\2\u00e9\u00ea\7\22\2\2\u00ea\u00ec\5\32\16\2\u00eb\u00ed\5h"+
		"\65\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\31\3\2\2\2\u00ee\u00ef"+
		"\5b\62\2\u00ef\u00f0\7\6\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2"+
		"\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\5b\62\2\u00f7\33\3\2\2\2\u00f8\u00fa"+
		"\5d\63\2\u00f9\u00fb\5h\65\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u0116\3\2\2\2\u00fc\u00fd\5 \21\2\u00fd\u00fe\5h\65\2\u00fe\u0116\3\2"+
		"\2\2\u00ff\u0100\5\36\20\2\u0100\u0101\5h\65\2\u0101\u0116\3\2\2\2\u0102"+
		"\u0104\5\"\22\2\u0103\u0105\5h\65\2\u0104\u0103\3\2\2\2\u0104\u0105\3"+
		"\2\2\2\u0105\u0116\3\2\2\2\u0106\u0108\5$\23\2\u0107\u0109\5h\65\2\u0108"+
		"\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0116\3\2\2\2\u010a\u010c\5&"+
		"\24\2\u010b\u010d\5h\65\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u0116\3\2\2\2\u010e\u0110\5(\25\2\u010f\u0111\5h\65\2\u0110\u010f\3\2"+
		"\2\2\u0110\u0111\3\2\2\2\u0111\u0116\3\2\2\2\u0112\u0113\5,\27\2\u0113"+
		"\u0114\5h\65\2\u0114\u0116\3\2\2\2\u0115\u00f8\3\2\2\2\u0115\u00fc\3\2"+
		"\2\2\u0115\u00ff\3\2\2\2\u0115\u0102\3\2\2\2\u0115\u0106\3\2\2\2\u0115"+
		"\u010a\3\2\2\2\u0115\u010e\3\2\2\2\u0115\u0112\3\2\2\2\u0116\35\3\2\2"+
		"\2\u0117\u0118\5f\64\2\u0118\u011b\5b\62\2\u0119\u011a\7\t\2\2\u011a\u011c"+
		"\5X-\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\7\f\2\2\u011e\u011f\5,\27\2\u011f\37\3\2\2\2\u0120\u0121\7\23\2"+
		"\2\u0121\u0122\5,\27\2\u0122!\3\2\2\2\u0123\u0124\7\24\2\2\u0124\u0125"+
		"\7\7\2\2\u0125\u0126\5,\27\2\u0126\u0127\7\b\2\2\u0127\u012a\5`\61\2\u0128"+
		"\u0129\7\25\2\2\u0129\u012b\5`\61\2\u012a\u0128\3\2\2\2\u012a\u012b\3"+
		"\2\2\2\u012b#\3\2\2\2\u012c\u012d\7\26\2\2\u012d\u012e\7\7\2\2\u012e\u012f"+
		"\5,\27\2\u012f\u0130\7\b\2\2\u0130\u0131\5`\61\2\u0131%\3\2\2\2\u0132"+
		"\u0133\7\27\2\2\u0133\u0134\5,\27\2\u0134\'\3\2\2\2\u0135\u0136\7\30\2"+
		"\2\u0136\u0137\7\7\2\2\u0137\u0138\5b\62\2\u0138\u0139\7\b\2\2\u0139\u013d"+
		"\7\16\2\2\u013a\u013c\5*\26\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2"+
		"\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0142\3\2\2\2\u013f\u013d"+
		"\3\2\2\2\u0140\u0141\7\25\2\2\u0141\u0143\5`\61\2\u0142\u0140\3\2\2\2"+
		"\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7\17\2\2\u0145)\3"+
		"\2\2\2\u0146\u0147\5X-\2\u0147\u0148\5`\61\2\u0148+\3\2\2\2\u0149\u014d"+
		"\5.\30\2\u014a\u014b\5@!\2\u014b\u014c\5,\27\2\u014c\u014e\3\2\2\2\u014d"+
		"\u014a\3\2\2\2\u014d\u014e\3\2\2\2\u014e-\3\2\2\2\u014f\u0152\5\60\31"+
		"\2\u0150\u0151\7\31\2\2\u0151\u0153\5.\30\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153/\3\2\2\2\u0154\u0157\5\62\32\2\u0155\u0156\7\32\2"+
		"\2\u0156\u0158\5\60\31\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\61\3\2\2\2\u0159\u015d\5\64\33\2\u015a\u015b\5B\"\2\u015b\u015c\5\62"+
		"\32\2\u015c\u015e\3\2\2\2\u015d\u015a\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\63\3\2\2\2\u015f\u0163\5\66\34\2\u0160\u0161\5D#\2\u0161\u0162\5\64\33"+
		"\2\u0162\u0164\3\2\2\2\u0163\u0160\3\2\2\2\u0163\u0164\3\2\2\2\u0164\65"+
		"\3\2\2\2\u0165\u0169\58\35\2\u0166\u0167\5F$\2\u0167\u0168\5\66\34\2\u0168"+
		"\u016a\3\2\2\2\u0169\u0166\3\2\2\2\u0169\u016a\3\2\2\2\u016a\67\3\2\2"+
		"\2\u016b\u016f\5:\36\2\u016c\u016d\5H%\2\u016d\u016e\58\35\2\u016e\u0170"+
		"\3\2\2\2\u016f\u016c\3\2\2\2\u016f\u0170\3\2\2\2\u01709\3\2\2\2\u0171"+
		"\u0173\5J&\2\u0172\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2"+
		"\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178"+
		"\5<\37\2\u0178;\3\2\2\2\u0179\u017d\5> \2\u017a\u017c\5L\'\2\u017b\u017a"+
		"\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"=\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0181\7\7\2\2\u0181\u0182\5,\27\2"+
		"\u0182\u0183\7\b\2\2\u0183\u018a\3\2\2\2\u0184\u018a\5R*\2\u0185\u018a"+
		"\5T+\2\u0186\u018a\5b\62\2\u0187\u018a\5d\63\2\u0188\u018a\5V,\2\u0189"+
		"\u0180\3\2\2\2\u0189\u0184\3\2\2\2\u0189\u0185\3\2\2\2\u0189\u0186\3\2"+
		"\2\2\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u018a?\3\2\2\2\u018b\u018c"+
		"\t\2\2\2\u018cA\3\2\2\2\u018d\u018e\t\3\2\2\u018eC\3\2\2\2\u018f\u0190"+
		"\t\4\2\2\u0190E\3\2\2\2\u0191\u0192\t\5\2\2\u0192G\3\2\2\2\u0193\u0194"+
		"\t\6\2\2\u0194I\3\2\2\2\u0195\u0196\t\7\2\2\u0196K\3\2\2\2\u0197\u019c"+
		"\7)\2\2\u0198\u019c\7*\2\2\u0199\u019c\5N(\2\u019a\u019c\5P)\2\u019b\u0197"+
		"\3\2\2\2\u019b\u0198\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c"+
		"M\3\2\2\2\u019d\u019e\7\4\2\2\u019e\u019f\5^\60\2\u019f\u01a0\7\5\2\2"+
		"\u01a0\u01a2\3\2\2\2\u01a1\u019d\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3"+
		"\3\2\2\2\u01a3\u01a4\7\7\2\2\u01a4\u01a5\5Z.\2\u01a5\u01a6\7\b\2\2\u01a6"+
		"O\3\2\2\2\u01a7\u01a8\7\6\2\2\u01a8\u01a9\5b\62\2\u01a9Q\3\2\2\2\u01aa"+
		"\u01ab\7\24\2\2\u01ab\u01ac\7\7\2\2\u01ac\u01ad\5,\27\2\u01ad\u01ae\7"+
		"\b\2\2\u01ae\u01af\5,\27\2\u01af\u01b0\7\25\2\2\u01b0\u01b1\5,\27\2\u01b1"+
		"S\3\2\2\2\u01b2\u01b3\7,\2\2\u01b3\u01b4\7\7\2\2\u01b4\u01b5\5X-\2\u01b5"+
		"\u01b6\7\b\2\2\u01b6U\3\2\2\2\u01b7\u01b8\t\b\2\2\u01b8W\3\2\2\2\u01b9"+
		"\u01ba\b-\1\2\u01ba\u01bf\5b\62\2\u01bb\u01bc\7\4\2\2\u01bc\u01bd\5^\60"+
		"\2\u01bd\u01be\7\5\2\2\u01be\u01c0\3\2\2\2\u01bf\u01bb\3\2\2\2\u01bf\u01c0"+
		"\3\2\2\2\u01c0\u01c8\3\2\2\2\u01c1\u01c2\7\7\2\2\u01c2\u01c3\5^\60\2\u01c3"+
		"\u01c4\7\b\2\2\u01c4\u01c5\7-\2\2\u01c5\u01c6\5X-\3\u01c6\u01c8\3\2\2"+
		"\2\u01c7\u01b9\3\2\2\2\u01c7\u01c1\3\2\2\2\u01c8\u01cd\3\2\2\2\u01c9\u01ca"+
		"\f\4\2\2\u01ca\u01cc\7&\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd"+
		"\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ceY\3\2\2\2\u01cf\u01cd\3\2\2\2"+
		"\u01d0\u01d1\5,\27\2\u01d1\u01d2\7\13\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d0"+
		"\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da\5,\27\2\u01d9\u01d8\3\2"+
		"\2\2\u01d9\u01da\3\2\2\2\u01da[\3\2\2\2\u01db\u01dc\5b\62\2\u01dc\u01dd"+
		"\7\13\2\2\u01dd\u01df\3\2\2\2\u01de\u01db\3\2\2\2\u01df\u01e2\3\2\2\2"+
		"\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0"+
		"\3\2\2\2\u01e3\u01e5\5b\62\2\u01e4\u01e3\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"]\3\2\2\2\u01e6\u01e7\5X-\2\u01e7\u01e8\7\13\2\2\u01e8\u01ea\3\2\2\2\u01e9"+
		"\u01e6\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2"+
		"\2\2\u01ec\u01f0\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f1\7.\2\2\u01ef"+
		"\u01f1\5X-\2\u01f0\u01ee\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1\3\2\2"+
		"\2\u01f1_\3\2\2\2\u01f2\u01f6\7\16\2\2\u01f3\u01f5\5\34\17\2\u01f4\u01f3"+
		"\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f9\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fb\7\17\2\2\u01fa\u01fc\5"+
		"h\65\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd"+
		"\u01ff\5\34\17\2\u01fe\u01f2\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ffa\3\2\2"+
		"\2\u0200\u0201\78\2\2\u0201c\3\2\2\2\u0202\u0203\7\67\2\2\u0203e\3\2\2"+
		"\2\u0204\u0205\t\t\2\2\u0205g\3\2\2\2\u0206\u0208\7\61\2\2\u0207\u0206"+
		"\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"i\3\2\2\2<ms{\u0082\u0085\u008d\u0093\u009c\u009f\u00aa\u00ae\u00b4\u00b6"+
		"\u00b9\u00c1\u00c7\u00cc\u00d3\u00d6\u00dd\u00e4\u00ec\u00f3\u00fa\u0104"+
		"\u0108\u010c\u0110\u0115\u011b\u012a\u013d\u0142\u014d\u0152\u0157\u015d"+
		"\u0163\u0169\u016f\u0174\u017d\u0189\u019b\u01a1\u01bf\u01c7\u01cd\u01d5"+
		"\u01d9\u01e0\u01e4\u01eb\u01f0\u01f6\u01fb\u01fe\u0209";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}