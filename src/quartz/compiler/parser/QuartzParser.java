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
		RULE_signatureDefinition = 3, RULE_fnArgument = 4, RULE_fnArgumentList = 5, 
		RULE_fnBlock = 6, RULE_structDeclaration = 7, RULE_structMember = 8, RULE_typealiasDeclaration = 9, 
		RULE_importDeclaration = 10, RULE_packageList = 11, RULE_statement = 12, 
		RULE_varDeclaration = 13, RULE_returnStatement = 14, RULE_ifStatement = 15, 
		RULE_whileLoop = 16, RULE_expression = 17, RULE_disjunction = 18, RULE_conjunction = 19, 
		RULE_equalityComparison = 20, RULE_comparison = 21, RULE_additiveExpression = 22, 
		RULE_multiplicativeExpression = 23, RULE_prefixExpression = 24, RULE_postfixExpression = 25, 
		RULE_atomicExpression = 26, RULE_assignmentOperator = 27, RULE_equalityOperation = 28, 
		RULE_comparisonOperation = 29, RULE_additiveOperation = 30, RULE_multiplicativeOperation = 31, 
		RULE_prefixOperation = 32, RULE_postfixOperation = 33, RULE_postfixCall = 34, 
		RULE_memberAccess = 35, RULE_lambda = 36, RULE_ifExpression = 37, RULE_sizeof = 38, 
		RULE_literal = 39, RULE_type = 40, RULE_ltype = 41, RULE_expressionList = 42, 
		RULE_identifierList = 43, RULE_typeList = 44, RULE_block = 45, RULE_identifier = 46, 
		RULE_inlineC = 47, RULE_varDeclarationType = 48, RULE_semi = 49;
	public static final String[] ruleNames = {
		"program", "declaration", "functionDeclaration", "signatureDefinition", 
		"fnArgument", "fnArgumentList", "fnBlock", "structDeclaration", "structMember", 
		"typealiasDeclaration", "importDeclaration", "packageList", "statement", 
		"varDeclaration", "returnStatement", "ifStatement", "whileLoop", "expression", 
		"disjunction", "conjunction", "equalityComparison", "comparison", "additiveExpression", 
		"multiplicativeExpression", "prefixExpression", "postfixExpression", "atomicExpression", 
		"assignmentOperator", "equalityOperation", "comparisonOperation", "additiveOperation", 
		"multiplicativeOperation", "prefixOperation", "postfixOperation", "postfixCall", 
		"memberAccess", "lambda", "ifExpression", "sizeof", "literal", "type", 
		"ltype", "expressionList", "identifierList", "typeList", "block", "identifier", 
		"inlineC", "varDeclarationType", "semi"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "')'", "':'", "'extern'", "','", "'='", "'struct'", 
		"'{'", "'}'", "'typealias'", "'import'", "'.'", "'return'", "'if'", "'else'", 
		"'while'", "'||'", "'&&'", "'+='", "'-='", "'*='", "'/='", "'%='", "'=='", 
		"'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", 
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(100);
				importDeclaration();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << INLINE_C))) != 0)) {
				{
				{
				setState(106);
				declaration();
				}
				}
				setState(111);
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
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				functionDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				structDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				typealiasDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
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
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(T__0);
				setState(119);
				identifier();
				setState(120);
				match(T__1);
				setState(121);
				fnArgumentList();
				setState(122);
				match(T__2);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(123);
					match(T__3);
					setState(124);
					((FunctionDeclarationContext)_localctx).returnType = type();
					}
				}

				setState(127);
				fnBlock();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__4);
				setState(130);
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
			setState(133);
			match(T__0);
			setState(134);
			identifier();
			setState(135);
			match(T__1);
			setState(136);
			typeList();
			setState(137);
			match(T__2);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(138);
				match(T__3);
				setState(139);
				((SignatureDefinitionContext)_localctx).returnType = type();
				}
			}

			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(142);
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
			setState(145);
			identifier();
			setState(146);
			match(T__3);
			setState(147);
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
		enterRule(_localctx, 10, RULE_fnArgumentList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(149);
					fnArgument();
					setState(150);
					match(T__5);
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(157);
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
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__8:
			case T__13:
			case T__14:
			case T__16:
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
				setState(160);
				block();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(T__6);
				setState(162);
				expression();
				setState(164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(163);
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
		enterRule(_localctx, 14, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(168);
				((StructDeclarationContext)_localctx).extern = match(T__4);
				}
			}

			setState(171);
			match(T__7);
			setState(172);
			identifier();
			setState(173);
			match(T__8);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__42 || _la==T__43) {
				{
				{
				setState(174);
				structMember();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			match(T__9);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(181);
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
			setState(184);
			varDeclarationType();
			setState(185);
			identifier();
			setState(186);
			match(T__3);
			setState(187);
			type();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(188);
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
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(191);
				((TypealiasDeclarationContext)_localctx).extern = match(T__4);
				}
			}

			setState(194);
			match(T__10);
			setState(195);
			identifier();
			setState(196);
			match(T__6);
			setState(197);
			type();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(198);
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
			setState(201);
			match(T__11);
			setState(202);
			packageList();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(203);
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
		enterRule(_localctx, 22, RULE_packageList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					identifier();
					setState(207);
					match(T__12);
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(214);
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
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				inlineC();
				setState(218);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(217);
					semi();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				returnStatement();
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(221);
					semi();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				varDeclaration();
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(225);
					semi();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				ifStatement();
				setState(230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(229);
					semi();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(232);
				whileLoop();
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(233);
					semi();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(236);
				expression();
				setState(238);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(237);
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
			setState(242);
			varDeclarationType();
			setState(243);
			identifier();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(244);
				match(T__3);
				setState(245);
				type();
				}
			}

			setState(248);
			match(T__6);
			setState(249);
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
			setState(251);
			match(T__13);
			setState(252);
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
			setState(254);
			match(T__14);
			setState(255);
			match(T__1);
			setState(256);
			expression();
			setState(257);
			match(T__2);
			setState(258);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(259);
				match(T__15);
				setState(260);
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
			setState(263);
			match(T__16);
			setState(264);
			match(T__1);
			setState(265);
			expression();
			setState(266);
			match(T__2);
			setState(267);
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
		enterRule(_localctx, 34, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			disjunction();
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(270);
				assignmentOperator();
				setState(271);
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
		enterRule(_localctx, 36, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			conjunction();
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(276);
				match(T__17);
				setState(277);
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
		enterRule(_localctx, 38, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			equalityComparison();
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(281);
				match(T__18);
				setState(282);
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
		enterRule(_localctx, 40, RULE_equalityComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			comparison();
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(286);
				equalityOperation();
				setState(287);
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
		enterRule(_localctx, 42, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			additiveExpression();
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(292);
				comparisonOperation();
				setState(293);
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
		enterRule(_localctx, 44, RULE_additiveExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			multiplicativeExpression();
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(298);
				additiveOperation();
				setState(299);
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
		enterRule(_localctx, 46, RULE_multiplicativeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			prefixExpression();
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(304);
				multiplicativeOperation();
				setState(305);
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
		enterRule(_localctx, 48, RULE_prefixExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) {
				{
				{
				setState(309);
				prefixOperation();
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(315);
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
		enterRule(_localctx, 50, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			atomicExpression();
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(318);
					postfixOperation();
					}
					} 
				}
				setState(323);
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
		enterRule(_localctx, 52, RULE_atomicExpression);
		try {
			setState(334);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				match(T__1);
				setState(325);
				expression();
				setState(326);
				match(T__2);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				lambda();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				ifExpression();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 4);
				{
				setState(330);
				sizeof();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(331);
				identifier();
				}
				break;
			case INLINE_C:
				enterOuterAlt(_localctx, 6);
				{
				setState(332);
				inlineC();
				}
				break;
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(333);
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
		enterRule(_localctx, 54, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
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
		enterRule(_localctx, 56, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !(_la==T__24 || _la==T__25) ) {
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
		enterRule(_localctx, 58, RULE_comparisonOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
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
		enterRule(_localctx, 60, RULE_additiveOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
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
		enterRule(_localctx, 62, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
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
		enterRule(_localctx, 64, RULE_prefixOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
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
		enterRule(_localctx, 66, RULE_postfixOperation);
		try {
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(T__36);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				postfixCall();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
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
		enterRule(_localctx, 68, RULE_postfixCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(T__1);
			setState(355);
			expressionList();
			setState(356);
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
		enterRule(_localctx, 70, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(T__12);
			setState(359);
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
		enterRule(_localctx, 72, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(T__0);
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(362);
				match(T__1);
				setState(363);
				fnArgumentList();
				setState(364);
				match(T__2);
				}
				break;
			}
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(368);
				match(T__3);
				setState(369);
				((LambdaContext)_localctx).returnType = type();
				}
			}

			setState(372);
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
		enterRule(_localctx, 74, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(T__14);
			setState(375);
			match(T__1);
			setState(376);
			((IfExpressionContext)_localctx).test = expression();
			setState(377);
			match(T__2);
			setState(378);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(379);
			match(T__15);
			setState(380);
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
		enterRule(_localctx, 76, RULE_sizeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(T__38);
			setState(383);
			match(T__1);
			setState(384);
			type();
			setState(385);
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
		enterRule(_localctx, 78, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
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
		enterRule(_localctx, 80, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39) {
				{
				setState(389);
				((TypeContext)_localctx).isConst = match(T__39);
				}
			}

			setState(392);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_ltype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(395);
				identifier();
				}
				break;
			case T__1:
				{
				setState(396);
				match(T__1);
				setState(397);
				((LtypeContext)_localctx).args = typeList();
				setState(398);
				match(T__2);
				setState(399);
				match(T__40);
				setState(400);
				((LtypeContext)_localctx).returnType = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(408);
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
					setState(404);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(405);
					((LtypeContext)_localctx).ptr = match(T__32);
					}
					} 
				}
				setState(410);
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
		enterRule(_localctx, 84, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(411);
					expression();
					setState(412);
					match(T__5);
					}
					} 
				}
				setState(418);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__14) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(419);
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
		enterRule(_localctx, 86, RULE_identifierList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(422);
					identifier();
					setState(423);
					match(T__5);
					}
					} 
				}
				setState(429);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(430);
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
		enterRule(_localctx, 88, RULE_typeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(433);
					type();
					setState(434);
					match(T__5);
					}
					} 
				}
				setState(440);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(443);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__41:
				{
				setState(441);
				((TypeListContext)_localctx).vararg = match(T__41);
				}
				break;
			case T__1:
			case T__39:
			case IDENTIFIER:
				{
				setState(442);
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
		enterRule(_localctx, 90, RULE_block);
		int _la;
		try {
			setState(457);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(445);
				match(T__8);
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__42) | (1L << T__43) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(446);
					statement();
					}
					}
					setState(451);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(452);
				match(T__9);
				setState(454);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(453);
					semi();
					}
					break;
				}
				}
				break;
			case T__0:
			case T__1:
			case T__13:
			case T__14:
			case T__16:
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
				setState(456);
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
		enterRule(_localctx, 92, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
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
		enterRule(_localctx, 94, RULE_inlineC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
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
		enterRule(_localctx, 96, RULE_varDeclarationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
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
		enterRule(_localctx, 98, RULE_semi);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(466); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(465);
					match(T__44);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(468); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
		case 41:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u01d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\7\2"+
		"h\n\2\f\2\16\2k\13\2\3\2\7\2n\n\2\f\2\16\2q\13\2\3\3\3\3\3\3\3\3\5\3w"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0080\n\4\3\4\3\4\3\4\3\4\5\4\u0086"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008f\n\5\3\5\5\5\u0092\n\5\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\7\7\u009b\n\7\f\7\16\7\u009e\13\7\3\7\5\7\u00a1"+
		"\n\7\3\b\3\b\3\b\3\b\5\b\u00a7\n\b\5\b\u00a9\n\b\3\t\5\t\u00ac\n\t\3\t"+
		"\3\t\3\t\3\t\7\t\u00b2\n\t\f\t\16\t\u00b5\13\t\3\t\3\t\5\t\u00b9\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u00c0\n\n\3\13\5\13\u00c3\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u00ca\n\13\3\f\3\f\3\f\5\f\u00cf\n\f\3\r\3\r\3\r\7\r\u00d4"+
		"\n\r\f\r\16\r\u00d7\13\r\3\r\3\r\3\16\3\16\5\16\u00dd\n\16\3\16\3\16\5"+
		"\16\u00e1\n\16\3\16\3\16\5\16\u00e5\n\16\3\16\3\16\5\16\u00e9\n\16\3\16"+
		"\3\16\5\16\u00ed\n\16\3\16\3\16\5\16\u00f1\n\16\5\16\u00f3\n\16\3\17\3"+
		"\17\3\17\3\17\5\17\u00f9\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0108\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\5\23\u0114\n\23\3\24\3\24\3\24\5\24\u0119\n\24\3"+
		"\25\3\25\3\25\5\25\u011e\n\25\3\26\3\26\3\26\3\26\5\26\u0124\n\26\3\27"+
		"\3\27\3\27\3\27\5\27\u012a\n\27\3\30\3\30\3\30\3\30\5\30\u0130\n\30\3"+
		"\31\3\31\3\31\3\31\5\31\u0136\n\31\3\32\7\32\u0139\n\32\f\32\16\32\u013c"+
		"\13\32\3\32\3\32\3\33\3\33\7\33\u0142\n\33\f\33\16\33\u0145\13\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0151\n\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\5#\u0163\n#\3$\3"+
		"$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\5&\u0171\n&\3&\3&\5&\u0175\n&\3&\3&\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3*\5*\u0189\n*\3*"+
		"\3*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0195\n+\3+\3+\7+\u0199\n+\f+\16+\u019c"+
		"\13+\3,\3,\3,\7,\u01a1\n,\f,\16,\u01a4\13,\3,\5,\u01a7\n,\3-\3-\3-\7-"+
		"\u01ac\n-\f-\16-\u01af\13-\3-\5-\u01b2\n-\3.\3.\3.\7.\u01b7\n.\f.\16."+
		"\u01ba\13.\3.\3.\5.\u01be\n.\3/\3/\7/\u01c2\n/\f/\16/\u01c5\13/\3/\3/"+
		"\5/\u01c9\n/\3/\5/\u01cc\n/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\6\63\u01d5"+
		"\n\63\r\63\16\63\u01d6\3\63\2\3T\64\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd\2\n\4\2\t\t\26\32\3\2"+
		"\33\34\3\2\35 \3\2!\"\3\2#%\4\2\"\"&(\3\2\61\64\3\2-.\u01ea\2i\3\2\2\2"+
		"\4v\3\2\2\2\6\u0085\3\2\2\2\b\u0087\3\2\2\2\n\u0093\3\2\2\2\f\u009c\3"+
		"\2\2\2\16\u00a8\3\2\2\2\20\u00ab\3\2\2\2\22\u00ba\3\2\2\2\24\u00c2\3\2"+
		"\2\2\26\u00cb\3\2\2\2\30\u00d5\3\2\2\2\32\u00f2\3\2\2\2\34\u00f4\3\2\2"+
		"\2\36\u00fd\3\2\2\2 \u0100\3\2\2\2\"\u0109\3\2\2\2$\u010f\3\2\2\2&\u0115"+
		"\3\2\2\2(\u011a\3\2\2\2*\u011f\3\2\2\2,\u0125\3\2\2\2.\u012b\3\2\2\2\60"+
		"\u0131\3\2\2\2\62\u013a\3\2\2\2\64\u013f\3\2\2\2\66\u0150\3\2\2\28\u0152"+
		"\3\2\2\2:\u0154\3\2\2\2<\u0156\3\2\2\2>\u0158\3\2\2\2@\u015a\3\2\2\2B"+
		"\u015c\3\2\2\2D\u0162\3\2\2\2F\u0164\3\2\2\2H\u0168\3\2\2\2J\u016b\3\2"+
		"\2\2L\u0178\3\2\2\2N\u0180\3\2\2\2P\u0185\3\2\2\2R\u0188\3\2\2\2T\u0194"+
		"\3\2\2\2V\u01a2\3\2\2\2X\u01ad\3\2\2\2Z\u01b8\3\2\2\2\\\u01cb\3\2\2\2"+
		"^\u01cd\3\2\2\2`\u01cf\3\2\2\2b\u01d1\3\2\2\2d\u01d4\3\2\2\2fh\5\26\f"+
		"\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jo\3\2\2\2ki\3\2\2\2ln\5\4\3"+
		"\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\3\3\2\2\2qo\3\2\2\2rw\5\6"+
		"\4\2sw\5\20\t\2tw\5\24\13\2uw\5`\61\2vr\3\2\2\2vs\3\2\2\2vt\3\2\2\2vu"+
		"\3\2\2\2w\5\3\2\2\2xy\7\3\2\2yz\5^\60\2z{\7\4\2\2{|\5\f\7\2|\177\7\5\2"+
		"\2}~\7\6\2\2~\u0080\5R*\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0082\5\16\b\2\u0082\u0086\3\2\2\2\u0083\u0084\7\7\2\2\u0084"+
		"\u0086\5\b\5\2\u0085x\3\2\2\2\u0085\u0083\3\2\2\2\u0086\7\3\2\2\2\u0087"+
		"\u0088\7\3\2\2\u0088\u0089\5^\60\2\u0089\u008a\7\4\2\2\u008a\u008b\5Z"+
		".\2\u008b\u008e\7\5\2\2\u008c\u008d\7\6\2\2\u008d\u008f\5R*\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0092\5d\63\2\u0091"+
		"\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\t\3\2\2\2\u0093\u0094\5^\60\2"+
		"\u0094\u0095\7\6\2\2\u0095\u0096\5R*\2\u0096\13\3\2\2\2\u0097\u0098\5"+
		"\n\6\2\u0098\u0099\7\b\2\2\u0099\u009b\3\2\2\2\u009a\u0097\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\5\n\6\2\u00a0\u009f\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\r\3\2\2\2\u00a2\u00a9\5\\/\2\u00a3\u00a4\7\t\2\2"+
		"\u00a4\u00a6\5$\23\2\u00a5\u00a7\5d\63\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a9"+
		"\17\3\2\2\2\u00aa\u00ac\7\7\2\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2"+
		"\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\n\2\2\u00ae\u00af\5^\60\2\u00af\u00b3"+
		"\7\13\2\2\u00b0\u00b2\5\22\n\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00b8\7\f\2\2\u00b7\u00b9\5d\63\2\u00b8\u00b7\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\21\3\2\2\2\u00ba\u00bb\5b\62\2\u00bb\u00bc\5^\60"+
		"\2\u00bc\u00bd\7\6\2\2\u00bd\u00bf\5R*\2\u00be\u00c0\5d\63\2\u00bf\u00be"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\23\3\2\2\2\u00c1\u00c3\7\7\2\2\u00c2"+
		"\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7\r"+
		"\2\2\u00c5\u00c6\5^\60\2\u00c6\u00c7\7\t\2\2\u00c7\u00c9\5R*\2\u00c8\u00ca"+
		"\5d\63\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\25\3\2\2\2\u00cb"+
		"\u00cc\7\16\2\2\u00cc\u00ce\5\30\r\2\u00cd\u00cf\5d\63\2\u00ce\u00cd\3"+
		"\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\27\3\2\2\2\u00d0\u00d1\5^\60\2\u00d1"+
		"\u00d2\7\17\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d4\u00d7\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00d9\5^\60\2\u00d9\31\3\2\2\2\u00da\u00dc\5`\61"+
		"\2\u00db\u00dd\5d\63\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00f3"+
		"\3\2\2\2\u00de\u00e0\5\36\20\2\u00df\u00e1\5d\63\2\u00e0\u00df\3\2\2\2"+
		"\u00e0\u00e1\3\2\2\2\u00e1\u00f3\3\2\2\2\u00e2\u00e4\5\34\17\2\u00e3\u00e5"+
		"\5d\63\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00f3\3\2\2\2\u00e6"+
		"\u00e8\5 \21\2\u00e7\u00e9\5d\63\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2"+
		"\2\2\u00e9\u00f3\3\2\2\2\u00ea\u00ec\5\"\22\2\u00eb\u00ed\5d\63\2\u00ec"+
		"\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f3\3\2\2\2\u00ee\u00f0\5$"+
		"\23\2\u00ef\u00f1\5d\63\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f3\3\2\2\2\u00f2\u00da\3\2\2\2\u00f2\u00de\3\2\2\2\u00f2\u00e2\3\2"+
		"\2\2\u00f2\u00e6\3\2\2\2\u00f2\u00ea\3\2\2\2\u00f2\u00ee\3\2\2\2\u00f3"+
		"\33\3\2\2\2\u00f4\u00f5\5b\62\2\u00f5\u00f8\5^\60\2\u00f6\u00f7\7\6\2"+
		"\2\u00f7\u00f9\5R*\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fb\7\t\2\2\u00fb\u00fc\5$\23\2\u00fc\35\3\2\2\2\u00fd"+
		"\u00fe\7\20\2\2\u00fe\u00ff\5$\23\2\u00ff\37\3\2\2\2\u0100\u0101\7\21"+
		"\2\2\u0101\u0102\7\4\2\2\u0102\u0103\5$\23\2\u0103\u0104\7\5\2\2\u0104"+
		"\u0107\5\\/\2\u0105\u0106\7\22\2\2\u0106\u0108\5\\/\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108!\3\2\2\2\u0109\u010a\7\23\2\2\u010a\u010b"+
		"\7\4\2\2\u010b\u010c\5$\23\2\u010c\u010d\7\5\2\2\u010d\u010e\5\\/\2\u010e"+
		"#\3\2\2\2\u010f\u0113\5&\24\2\u0110\u0111\58\35\2\u0111\u0112\5$\23\2"+
		"\u0112\u0114\3\2\2\2\u0113\u0110\3\2\2\2\u0113\u0114\3\2\2\2\u0114%\3"+
		"\2\2\2\u0115\u0118\5(\25\2\u0116\u0117\7\24\2\2\u0117\u0119\5&\24\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\'\3\2\2\2\u011a\u011d\5*\26\2"+
		"\u011b\u011c\7\25\2\2\u011c\u011e\5(\25\2\u011d\u011b\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e)\3\2\2\2\u011f\u0123\5,\27\2\u0120\u0121\5:\36\2\u0121"+
		"\u0122\5*\26\2\u0122\u0124\3\2\2\2\u0123\u0120\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124+\3\2\2\2\u0125\u0129\5.\30\2\u0126\u0127\5<\37\2\u0127\u0128"+
		"\5,\27\2\u0128\u012a\3\2\2\2\u0129\u0126\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"-\3\2\2\2\u012b\u012f\5\60\31\2\u012c\u012d\5> \2\u012d\u012e\5.\30\2"+
		"\u012e\u0130\3\2\2\2\u012f\u012c\3\2\2\2\u012f\u0130\3\2\2\2\u0130/\3"+
		"\2\2\2\u0131\u0135\5\62\32\2\u0132\u0133\5@!\2\u0133\u0134\5\60\31\2\u0134"+
		"\u0136\3\2\2\2\u0135\u0132\3\2\2\2\u0135\u0136\3\2\2\2\u0136\61\3\2\2"+
		"\2\u0137\u0139\5B\"\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u013e\5\64\33\2\u013e\63\3\2\2\2\u013f\u0143\5\66\34\2\u0140\u0142\5"+
		"D#\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\65\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7\4\2"+
		"\2\u0147\u0148\5$\23\2\u0148\u0149\7\5\2\2\u0149\u0151\3\2\2\2\u014a\u0151"+
		"\5J&\2\u014b\u0151\5L\'\2\u014c\u0151\5N(\2\u014d\u0151\5^\60\2\u014e"+
		"\u0151\5`\61\2\u014f\u0151\5P)\2\u0150\u0146\3\2\2\2\u0150\u014a\3\2\2"+
		"\2\u0150\u014b\3\2\2\2\u0150\u014c\3\2\2\2\u0150\u014d\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0150\u014f\3\2\2\2\u0151\67\3\2\2\2\u0152\u0153\t\2\2\2\u0153"+
		"9\3\2\2\2\u0154\u0155\t\3\2\2\u0155;\3\2\2\2\u0156\u0157\t\4\2\2\u0157"+
		"=\3\2\2\2\u0158\u0159\t\5\2\2\u0159?\3\2\2\2\u015a\u015b\t\6\2\2\u015b"+
		"A\3\2\2\2\u015c\u015d\t\7\2\2\u015dC\3\2\2\2\u015e\u0163\7&\2\2\u015f"+
		"\u0163\7\'\2\2\u0160\u0163\5F$\2\u0161\u0163\5H%\2\u0162\u015e\3\2\2\2"+
		"\u0162\u015f\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163E\3"+
		"\2\2\2\u0164\u0165\7\4\2\2\u0165\u0166\5V,\2\u0166\u0167\7\5\2\2\u0167"+
		"G\3\2\2\2\u0168\u0169\7\17\2\2\u0169\u016a\5^\60\2\u016aI\3\2\2\2\u016b"+
		"\u0170\7\3\2\2\u016c\u016d\7\4\2\2\u016d\u016e\5\f\7\2\u016e\u016f\7\5"+
		"\2\2\u016f\u0171\3\2\2\2\u0170\u016c\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u0174\3\2\2\2\u0172\u0173\7\6\2\2\u0173\u0175\5R*\2\u0174\u0172\3\2\2"+
		"\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\5\16\b\2\u0177"+
		"K\3\2\2\2\u0178\u0179\7\21\2\2\u0179\u017a\7\4\2\2\u017a\u017b\5$\23\2"+
		"\u017b\u017c\7\5\2\2\u017c\u017d\5$\23\2\u017d\u017e\7\22\2\2\u017e\u017f"+
		"\5$\23\2\u017fM\3\2\2\2\u0180\u0181\7)\2\2\u0181\u0182\7\4\2\2\u0182\u0183"+
		"\5R*\2\u0183\u0184\7\5\2\2\u0184O\3\2\2\2\u0185\u0186\t\b\2\2\u0186Q\3"+
		"\2\2\2\u0187\u0189\7*\2\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u018b\5T+\2\u018bS\3\2\2\2\u018c\u018d\b+\1\2\u018d"+
		"\u0195\5^\60\2\u018e\u018f\7\4\2\2\u018f\u0190\5Z.\2\u0190\u0191\7\5\2"+
		"\2\u0191\u0192\7+\2\2\u0192\u0193\5R*\2\u0193\u0195\3\2\2\2\u0194\u018c"+
		"\3\2\2\2\u0194\u018e\3\2\2\2\u0195\u019a\3\2\2\2\u0196\u0197\f\4\2\2\u0197"+
		"\u0199\7#\2\2\u0198\u0196\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2"+
		"\2\2\u019a\u019b\3\2\2\2\u019bU\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e"+
		"\5$\23\2\u019e\u019f\7\b\2\2\u019f\u01a1\3\2\2\2\u01a0\u019d\3\2\2\2\u01a1"+
		"\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a6\3\2"+
		"\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a7\5$\23\2\u01a6\u01a5\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7W\3\2\2\2\u01a8\u01a9\5^\60\2\u01a9\u01aa\7\b\2\2"+
		"\u01aa\u01ac\3\2\2\2\u01ab\u01a8\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab"+
		"\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0"+
		"\u01b2\5^\60\2\u01b1\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2Y\3\2\2\2"+
		"\u01b3\u01b4\5R*\2\u01b4\u01b5\7\b\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b3"+
		"\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01bd\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01be\7,\2\2\u01bc\u01be\5R*"+
		"\2\u01bd\u01bb\3\2\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be["+
		"\3\2\2\2\u01bf\u01c3\7\13\2\2\u01c0\u01c2\5\32\16\2\u01c1\u01c0\3\2\2"+
		"\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6"+
		"\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01c8\7\f\2\2\u01c7\u01c9\5d\63\2\u01c8"+
		"\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01cc\5\32"+
		"\16\2\u01cb\u01bf\3\2\2\2\u01cb\u01ca\3\2\2\2\u01cc]\3\2\2\2\u01cd\u01ce"+
		"\7\66\2\2\u01ce_\3\2\2\2\u01cf\u01d0\7\65\2\2\u01d0a\3\2\2\2\u01d1\u01d2"+
		"\t\t\2\2\u01d2c\3\2\2\2\u01d3\u01d5\7/\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d6"+
		"\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7e\3\2\2\28iov\177"+
		"\u0085\u008e\u0091\u009c\u00a0\u00a6\u00a8\u00ab\u00b3\u00b8\u00bf\u00c2"+
		"\u00c9\u00ce\u00d5\u00dc\u00e0\u00e4\u00e8\u00ec\u00f0\u00f2\u00f8\u0107"+
		"\u0113\u0118\u011d\u0123\u0129\u012f\u0135\u013a\u0143\u0150\u0162\u0170"+
		"\u0174\u0188\u0194\u019a\u01a2\u01a6\u01ad\u01b1\u01b8\u01bd\u01c3\u01c8"+
		"\u01cb\u01d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}