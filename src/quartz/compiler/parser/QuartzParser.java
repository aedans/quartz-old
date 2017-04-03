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
		T__38=39, DMOD=40, STRING=41, CHAR=42, INT=43, DOUBLE=44, INLINE_C=45, 
		IDENTIFIER=46, BLOCK_COMMENT=47, LINE_COMMENT=48, WHITESPACE=49;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_fnDeclaration = 2, RULE_fnArgument = 3, 
		RULE_fnArgumentList = 4, RULE_fnModifiers = 5, RULE_fnBlock = 6, RULE_structDeclaration = 7, 
		RULE_structMember = 8, RULE_typealiasDeclaration = 9, RULE_importDeclaration = 10, 
		RULE_packageList = 11, RULE_statement = 12, RULE_varDeclaration = 13, 
		RULE_returnStatement = 14, RULE_ifStatement = 15, RULE_whileLoop = 16, 
		RULE_expression = 17, RULE_disjunction = 18, RULE_conjunction = 19, RULE_equalityComparison = 20, 
		RULE_comparison = 21, RULE_additiveExpression = 22, RULE_multiplicativeExpression = 23, 
		RULE_prefixExpression = 24, RULE_postfixExpression = 25, RULE_atomicExpression = 26, 
		RULE_equalityOperation = 27, RULE_comparisonOperation = 28, RULE_additiveOperation = 29, 
		RULE_multiplicativeOperation = 30, RULE_prefixOperation = 31, RULE_postfixOperation = 32, 
		RULE_arrayAccess = 33, RULE_postfixCall = 34, RULE_memberAccess = 35, 
		RULE_ifExpression = 36, RULE_literal = 37, RULE_type = 38, RULE_expressionList = 39, 
		RULE_identifierList = 40, RULE_typeList = 41, RULE_block = 42, RULE_identifier = 43, 
		RULE_inlineC = 44, RULE_varDeclarationType = 45, RULE_semi = 46;
	public static final String[] ruleNames = {
		"program", "declaration", "fnDeclaration", "fnArgument", "fnArgumentList", 
		"fnModifiers", "fnBlock", "structDeclaration", "structMember", "typealiasDeclaration", 
		"importDeclaration", "packageList", "statement", "varDeclaration", "returnStatement", 
		"ifStatement", "whileLoop", "expression", "disjunction", "conjunction", 
		"equalityComparison", "comparison", "additiveExpression", "multiplicativeExpression", 
		"prefixExpression", "postfixExpression", "atomicExpression", "equalityOperation", 
		"comparisonOperation", "additiveOperation", "multiplicativeOperation", 
		"prefixOperation", "postfixOperation", "arrayAccess", "postfixCall", "memberAccess", 
		"ifExpression", "literal", "type", "expressionList", "identifierList", 
		"typeList", "block", "identifier", "inlineC", "varDeclarationType", "semi"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'('", "')'", "':'", "'extern'", "','", "'='", "'struct'", 
		"'{'", "'}'", "'typealias'", "'import'", "'.'", "'return'", "'if'", "'else'", 
		"'while'", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'['", "']'", "'[]'", "'->'", 
		"'...'", "'var'", "'val'", "';'", "'%%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", 
		"IDENTIFIER", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
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
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(94);
				importDeclaration();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << INLINE_C))) != 0)) {
				{
				{
				setState(100);
				declaration();
				}
				}
				setState(105);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				fnDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				structDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				typealiasDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
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
		public TypeContext returnType;
		public FnBlockContext body;
		public Token extern;
		public FnModifiersContext fnModifiers() {
			return getRuleContext(FnModifiersContext.class,0);
		}
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
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
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
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				fnModifiers();
				setState(113);
				match(T__0);
				setState(114);
				identifier();
				setState(115);
				match(T__1);
				setState(116);
				fnArgumentList();
				setState(117);
				match(T__2);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(118);
					match(T__3);
					setState(119);
					((FnDeclarationContext)_localctx).returnType = type(0);
					}
				}

				setState(122);
				((FnDeclarationContext)_localctx).body = fnBlock();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				fnModifiers();
				setState(125);
				((FnDeclarationContext)_localctx).extern = match(T__4);
				setState(126);
				match(T__0);
				setState(127);
				identifier();
				setState(128);
				match(T__1);
				setState(129);
				typeList();
				setState(130);
				match(T__2);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(131);
					match(T__3);
					setState(132);
					((FnDeclarationContext)_localctx).returnType = type(0);
					}
				}

				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__38) {
					{
					setState(135);
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
		enterRule(_localctx, 6, RULE_fnArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(140);
			identifier();
			setState(141);
			match(T__3);
			setState(142);
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
		enterRule(_localctx, 8, RULE_fnArgumentList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					fnArgument();
					setState(145);
					match(T__5);
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(152);
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
		public FnModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnModifiers; }
	}

	public final FnModifiersContext fnModifiers() throws RecognitionException {
		FnModifiersContext _localctx = new FnModifiersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fnModifiers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
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
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__8:
			case T__13:
			case T__14:
			case T__16:
			case T__26:
			case T__30:
			case T__36:
			case T__37:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				block();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(T__6);
				setState(159);
				expression();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__38) {
					{
					setState(160);
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
			setState(165);
			match(T__7);
			setState(166);
			identifier();
			setState(167);
			match(T__8);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36 || _la==T__37) {
				{
				{
				setState(168);
				structMember();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			match(T__9);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__38) {
				{
				setState(175);
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
			setState(178);
			varDeclarationType();
			setState(179);
			identifier();
			setState(180);
			match(T__3);
			setState(181);
			type(0);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__38) {
				{
				setState(182);
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
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(185);
				((TypealiasDeclarationContext)_localctx).extern = match(T__4);
				}
			}

			setState(188);
			match(T__10);
			setState(189);
			identifier();
			setState(190);
			match(T__6);
			setState(191);
			type(0);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__38) {
				{
				setState(192);
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
			setState(195);
			match(T__11);
			setState(196);
			packageList();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__38) {
				{
				setState(197);
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
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(200);
					identifier();
					setState(201);
					match(T__12);
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(208);
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
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				inlineC();
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(211);
					semi();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				returnStatement();
				setState(215);
				semi();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				varDeclaration();
				setState(218);
				semi();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				ifStatement();
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(221);
					semi();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(224);
				whileLoop();
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(225);
					semi();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(228);
				expression();
				setState(229);
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
		enterRule(_localctx, 26, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			varDeclarationType();
			setState(234);
			identifier();
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(235);
				match(T__3);
				setState(236);
				type(0);
				}
			}

			setState(239);
			match(T__6);
			setState(240);
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
			setState(242);
			match(T__13);
			setState(243);
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
			setState(245);
			match(T__14);
			setState(246);
			match(T__1);
			setState(247);
			expression();
			setState(248);
			match(T__2);
			setState(249);
			((IfStatementContext)_localctx).trueBlock = block();
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(250);
				match(T__15);
				setState(251);
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
			setState(254);
			match(T__16);
			setState(255);
			match(T__1);
			setState(256);
			expression();
			setState(257);
			match(T__2);
			setState(258);
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
		enterRule(_localctx, 34, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
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
		enterRule(_localctx, 36, RULE_disjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			conjunction();
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(263);
				match(T__17);
				setState(264);
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
			setState(267);
			equalityComparison();
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(268);
				match(T__18);
				setState(269);
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
			setState(272);
			comparison();
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(273);
				equalityOperation();
				setState(274);
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
			setState(278);
			additiveExpression();
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(279);
				comparisonOperation();
				setState(280);
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
			setState(284);
			multiplicativeExpression();
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(285);
				additiveOperation();
				setState(286);
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
			setState(290);
			prefixExpression();
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(291);
				multiplicativeOperation();
				setState(292);
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
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__26 || _la==T__30) {
				{
				{
				setState(296);
				prefixOperation();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
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
			setState(304);
			atomicExpression();
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(305);
					postfixOperation();
					}
					} 
				}
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 52, RULE_atomicExpression);
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				match(T__1);
				setState(312);
				expression();
				setState(313);
				match(T__2);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				ifExpression();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				identifier();
				}
				break;
			case INLINE_C:
				enterOuterAlt(_localctx, 4);
				{
				setState(317);
				inlineC();
				}
				break;
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
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
		enterRule(_localctx, 54, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__20) ) {
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
		enterRule(_localctx, 56, RULE_comparisonOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
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
		enterRule(_localctx, 58, RULE_additiveOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
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
		enterRule(_localctx, 60, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
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
		enterRule(_localctx, 62, RULE_prefixOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__30) ) {
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
		enterRule(_localctx, 64, RULE_postfixOperation);
		try {
			setState(334);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				arrayAccess();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				postfixCall();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(333);
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
		enterRule(_localctx, 66, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(T__31);
			setState(337);
			expression();
			setState(338);
			match(T__32);
			}
		}
		catch (RecognitionException re) {
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
			setState(340);
			match(T__1);
			setState(341);
			expressionList();
			setState(342);
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
			setState(344);
			match(T__12);
			setState(345);
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
		enterRule(_localctx, 72, RULE_ifExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(T__14);
			setState(348);
			match(T__1);
			setState(349);
			((IfExpressionContext)_localctx).test = expression();
			setState(350);
			match(T__2);
			setState(351);
			((IfExpressionContext)_localctx).ifTrue = expression();
			setState(352);
			match(T__15);
			setState(353);
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
		enterRule(_localctx, 74, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
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
		public Token array;
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
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(358);
				identifier();
				}
				break;
			case T__1:
				{
				setState(359);
				match(T__1);
				setState(360);
				((TypeContext)_localctx).args = typeList();
				setState(361);
				match(T__2);
				setState(362);
				match(T__34);
				setState(363);
				((TypeContext)_localctx).returnType = type(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(367);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(368);
					((TypeContext)_localctx).array = match(T__33);
					}
					} 
				}
				setState(373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		enterRule(_localctx, 78, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(374);
					expression();
					setState(375);
					match(T__5);
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__26) | (1L << T__30) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(382);
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
		enterRule(_localctx, 80, RULE_identifierList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(385);
					identifier();
					setState(386);
					match(T__5);
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(393);
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
		enterRule(_localctx, 82, RULE_typeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(396);
					type(0);
					setState(397);
					match(T__5);
					}
					} 
				}
				setState(403);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				{
				setState(404);
				((TypeListContext)_localctx).vararg = match(T__35);
				}
				break;
			case T__1:
			case IDENTIFIER:
				{
				setState(405);
				type(0);
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
		enterRule(_localctx, 84, RULE_block);
		int _la;
		try {
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(T__8);
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__26) | (1L << T__30) | (1L << T__36) | (1L << T__37) | (1L << STRING) | (1L << CHAR) | (1L << INT) | (1L << DOUBLE) | (1L << INLINE_C) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(409);
					statement();
					}
					}
					setState(414);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(415);
				match(T__9);
				setState(417);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(416);
					semi();
					}
					break;
				}
				}
				break;
			case T__1:
			case T__13:
			case T__14:
			case T__16:
			case T__26:
			case T__30:
			case T__36:
			case T__37:
			case STRING:
			case CHAR:
			case INT:
			case DOUBLE:
			case INLINE_C:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
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
		enterRule(_localctx, 86, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
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
		enterRule(_localctx, 88, RULE_inlineC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
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
		enterRule(_localctx, 90, RULE_varDeclarationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_la = _input.LA(1);
			if ( !(_la==T__36 || _la==T__37) ) {
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
		enterRule(_localctx, 92, RULE_semi);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(429); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(428);
					match(T__38);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(431); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		case 38:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u01b4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\7\2b\n\2\f\2\16\2e\13\2\3\2\7\2h"+
		"\n\2\f\2\16\2k\13\2\3\3\3\3\3\3\3\3\5\3q\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4{\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0088"+
		"\n\4\3\4\5\4\u008b\n\4\5\4\u008d\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u0096"+
		"\n\6\f\6\16\6\u0099\13\6\3\6\5\6\u009c\n\6\3\7\3\7\3\b\3\b\3\b\3\b\5\b"+
		"\u00a4\n\b\5\b\u00a6\n\b\3\t\3\t\3\t\3\t\7\t\u00ac\n\t\f\t\16\t\u00af"+
		"\13\t\3\t\3\t\5\t\u00b3\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00ba\n\n\3\13\5\13"+
		"\u00bd\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c4\n\13\3\f\3\f\3\f\5\f\u00c9"+
		"\n\f\3\r\3\r\3\r\7\r\u00ce\n\r\f\r\16\r\u00d1\13\r\3\r\3\r\3\16\3\16\5"+
		"\16\u00d7\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00e1\n\16"+
		"\3\16\3\16\5\16\u00e5\n\16\3\16\3\16\3\16\5\16\u00ea\n\16\3\17\3\17\3"+
		"\17\3\17\5\17\u00f0\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00ff\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\5\24\u010c\n\24\3\25\3\25\3\25\5\25\u0111\n\25\3"+
		"\26\3\26\3\26\3\26\5\26\u0117\n\26\3\27\3\27\3\27\3\27\5\27\u011d\n\27"+
		"\3\30\3\30\3\30\3\30\5\30\u0123\n\30\3\31\3\31\3\31\3\31\5\31\u0129\n"+
		"\31\3\32\7\32\u012c\n\32\f\32\16\32\u012f\13\32\3\32\3\32\3\33\3\33\7"+
		"\33\u0135\n\33\f\33\16\33\u0138\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\5\34\u0142\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3\"\5\"\u0151\n\"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0170\n(\3(\3(\7(\u0174"+
		"\n(\f(\16(\u0177\13(\3)\3)\3)\7)\u017c\n)\f)\16)\u017f\13)\3)\5)\u0182"+
		"\n)\3*\3*\3*\7*\u0187\n*\f*\16*\u018a\13*\3*\5*\u018d\n*\3+\3+\3+\7+\u0192"+
		"\n+\f+\16+\u0195\13+\3+\3+\5+\u0199\n+\3,\3,\7,\u019d\n,\f,\16,\u01a0"+
		"\13,\3,\3,\5,\u01a4\n,\3,\5,\u01a7\n,\3-\3-\3.\3.\3/\3/\3\60\6\60\u01b0"+
		"\n\60\r\60\16\60\u01b1\3\60\2\3N\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\t\3\2\26\27\3\2\30\33"+
		"\3\2\34\35\3\2\36 \4\2\35\35!!\3\2+.\3\2\'(\u01bd\2c\3\2\2\2\4p\3\2\2"+
		"\2\6\u008c\3\2\2\2\b\u008e\3\2\2\2\n\u0097\3\2\2\2\f\u009d\3\2\2\2\16"+
		"\u00a5\3\2\2\2\20\u00a7\3\2\2\2\22\u00b4\3\2\2\2\24\u00bc\3\2\2\2\26\u00c5"+
		"\3\2\2\2\30\u00cf\3\2\2\2\32\u00e9\3\2\2\2\34\u00eb\3\2\2\2\36\u00f4\3"+
		"\2\2\2 \u00f7\3\2\2\2\"\u0100\3\2\2\2$\u0106\3\2\2\2&\u0108\3\2\2\2(\u010d"+
		"\3\2\2\2*\u0112\3\2\2\2,\u0118\3\2\2\2.\u011e\3\2\2\2\60\u0124\3\2\2\2"+
		"\62\u012d\3\2\2\2\64\u0132\3\2\2\2\66\u0141\3\2\2\28\u0143\3\2\2\2:\u0145"+
		"\3\2\2\2<\u0147\3\2\2\2>\u0149\3\2\2\2@\u014b\3\2\2\2B\u0150\3\2\2\2D"+
		"\u0152\3\2\2\2F\u0156\3\2\2\2H\u015a\3\2\2\2J\u015d\3\2\2\2L\u0165\3\2"+
		"\2\2N\u016f\3\2\2\2P\u017d\3\2\2\2R\u0188\3\2\2\2T\u0193\3\2\2\2V\u01a6"+
		"\3\2\2\2X\u01a8\3\2\2\2Z\u01aa\3\2\2\2\\\u01ac\3\2\2\2^\u01af\3\2\2\2"+
		"`b\5\26\f\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2di\3\2\2\2ec\3\2\2"+
		"\2fh\5\4\3\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\3\3\2\2\2ki\3\2"+
		"\2\2lq\5\6\4\2mq\5\20\t\2nq\5\24\13\2oq\5Z.\2pl\3\2\2\2pm\3\2\2\2pn\3"+
		"\2\2\2po\3\2\2\2q\5\3\2\2\2rs\5\f\7\2st\7\3\2\2tu\5X-\2uv\7\4\2\2vw\5"+
		"\n\6\2wz\7\5\2\2xy\7\6\2\2y{\5N(\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\5\16"+
		"\b\2}\u008d\3\2\2\2~\177\5\f\7\2\177\u0080\7\7\2\2\u0080\u0081\7\3\2\2"+
		"\u0081\u0082\5X-\2\u0082\u0083\7\4\2\2\u0083\u0084\5T+\2\u0084\u0087\7"+
		"\5\2\2\u0085\u0086\7\6\2\2\u0086\u0088\5N(\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u008b\5^\60\2\u008a\u0089\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008cr\3\2\2\2\u008c~\3\2"+
		"\2\2\u008d\7\3\2\2\2\u008e\u008f\5X-\2\u008f\u0090\7\6\2\2\u0090\u0091"+
		"\5N(\2\u0091\t\3\2\2\2\u0092\u0093\5\b\5\2\u0093\u0094\7\b\2\2\u0094\u0096"+
		"\3\2\2\2\u0095\u0092\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\5\b"+
		"\5\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\13\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\r\3\2\2\2\u009f\u00a6\5V,\2\u00a0\u00a1\7\t\2\2\u00a1\u00a3"+
		"\5$\23\2\u00a2\u00a4\5^\60\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a6\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a6\17\3\2\2"+
		"\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9\5X-\2\u00a9\u00ad\7\13\2\2\u00aa\u00ac"+
		"\5\22\n\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2"+
		"\7\f\2\2\u00b1\u00b3\5^\60\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\21\3\2\2\2\u00b4\u00b5\5\\/\2\u00b5\u00b6\5X-\2\u00b6\u00b7\7\6\2\2\u00b7"+
		"\u00b9\5N(\2\u00b8\u00ba\5^\60\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2"+
		"\2\u00ba\23\3\2\2\2\u00bb\u00bd\7\7\2\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\r\2\2\u00bf\u00c0\5X-\2\u00c0"+
		"\u00c1\7\t\2\2\u00c1\u00c3\5N(\2\u00c2\u00c4\5^\60\2\u00c3\u00c2\3\2\2"+
		"\2\u00c3\u00c4\3\2\2\2\u00c4\25\3\2\2\2\u00c5\u00c6\7\16\2\2\u00c6\u00c8"+
		"\5\30\r\2\u00c7\u00c9\5^\60\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2"+
		"\u00c9\27\3\2\2\2\u00ca\u00cb\5X-\2\u00cb\u00cc\7\17\2\2\u00cc\u00ce\3"+
		"\2\2\2\u00cd\u00ca\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\5X"+
		"-\2\u00d3\31\3\2\2\2\u00d4\u00d6\5Z.\2\u00d5\u00d7\5^\60\2\u00d6\u00d5"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00ea\3\2\2\2\u00d8\u00d9\5\36\20\2"+
		"\u00d9\u00da\5^\60\2\u00da\u00ea\3\2\2\2\u00db\u00dc\5\34\17\2\u00dc\u00dd"+
		"\5^\60\2\u00dd\u00ea\3\2\2\2\u00de\u00e0\5 \21\2\u00df\u00e1\5^\60\2\u00e0"+
		"\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00ea\3\2\2\2\u00e2\u00e4\5\""+
		"\22\2\u00e3\u00e5\5^\60\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00ea\3\2\2\2\u00e6\u00e7\5$\23\2\u00e7\u00e8\5^\60\2\u00e8\u00ea\3\2"+
		"\2\2\u00e9\u00d4\3\2\2\2\u00e9\u00d8\3\2\2\2\u00e9\u00db\3\2\2\2\u00e9"+
		"\u00de\3\2\2\2\u00e9\u00e2\3\2\2\2\u00e9\u00e6\3\2\2\2\u00ea\33\3\2\2"+
		"\2\u00eb\u00ec\5\\/\2\u00ec\u00ef\5X-\2\u00ed\u00ee\7\6\2\2\u00ee\u00f0"+
		"\5N(\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f2\7\t\2\2\u00f2\u00f3\5$\23\2\u00f3\35\3\2\2\2\u00f4\u00f5\7\20\2"+
		"\2\u00f5\u00f6\5$\23\2\u00f6\37\3\2\2\2\u00f7\u00f8\7\21\2\2\u00f8\u00f9"+
		"\7\4\2\2\u00f9\u00fa\5$\23\2\u00fa\u00fb\7\5\2\2\u00fb\u00fe\5V,\2\u00fc"+
		"\u00fd\7\22\2\2\u00fd\u00ff\5V,\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff!\3\2\2\2\u0100\u0101\7\23\2\2\u0101\u0102\7\4\2\2\u0102\u0103"+
		"\5$\23\2\u0103\u0104\7\5\2\2\u0104\u0105\5V,\2\u0105#\3\2\2\2\u0106\u0107"+
		"\5&\24\2\u0107%\3\2\2\2\u0108\u010b\5(\25\2\u0109\u010a\7\24\2\2\u010a"+
		"\u010c\5&\24\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\'\3\2\2\2"+
		"\u010d\u0110\5*\26\2\u010e\u010f\7\25\2\2\u010f\u0111\5(\25\2\u0110\u010e"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111)\3\2\2\2\u0112\u0116\5,\27\2\u0113"+
		"\u0114\58\35\2\u0114\u0115\5*\26\2\u0115\u0117\3\2\2\2\u0116\u0113\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117+\3\2\2\2\u0118\u011c\5.\30\2\u0119\u011a"+
		"\5:\36\2\u011a\u011b\5,\27\2\u011b\u011d\3\2\2\2\u011c\u0119\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d-\3\2\2\2\u011e\u0122\5\60\31\2\u011f\u0120\5<\37"+
		"\2\u0120\u0121\5.\30\2\u0121\u0123\3\2\2\2\u0122\u011f\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123/\3\2\2\2\u0124\u0128\5\62\32\2\u0125\u0126\5> \2\u0126"+
		"\u0127\5\60\31\2\u0127\u0129\3\2\2\2\u0128\u0125\3\2\2\2\u0128\u0129\3"+
		"\2\2\2\u0129\61\3\2\2\2\u012a\u012c\5@!\2\u012b\u012a\3\2\2\2\u012c\u012f"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u0130\u0131\5\64\33\2\u0131\63\3\2\2\2\u0132\u0136\5\66"+
		"\34\2\u0133\u0135\5B\"\2\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\65\3\2\2\2\u0138\u0136\3\2\2"+
		"\2\u0139\u013a\7\4\2\2\u013a\u013b\5$\23\2\u013b\u013c\7\5\2\2\u013c\u0142"+
		"\3\2\2\2\u013d\u0142\5J&\2\u013e\u0142\5X-\2\u013f\u0142\5Z.\2\u0140\u0142"+
		"\5L\'\2\u0141\u0139\3\2\2\2\u0141\u013d\3\2\2\2\u0141\u013e\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142\67\3\2\2\2\u0143\u0144\t\2\2"+
		"\2\u01449\3\2\2\2\u0145\u0146\t\3\2\2\u0146;\3\2\2\2\u0147\u0148\t\4\2"+
		"\2\u0148=\3\2\2\2\u0149\u014a\t\5\2\2\u014a?\3\2\2\2\u014b\u014c\t\6\2"+
		"\2\u014cA\3\2\2\2\u014d\u0151\5D#\2\u014e\u0151\5F$\2\u014f\u0151\5H%"+
		"\2\u0150\u014d\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2\2\2\u0151C"+
		"\3\2\2\2\u0152\u0153\7\"\2\2\u0153\u0154\5$\23\2\u0154\u0155\7#\2\2\u0155"+
		"E\3\2\2\2\u0156\u0157\7\4\2\2\u0157\u0158\5P)\2\u0158\u0159\7\5\2\2\u0159"+
		"G\3\2\2\2\u015a\u015b\7\17\2\2\u015b\u015c\5X-\2\u015cI\3\2\2\2\u015d"+
		"\u015e\7\21\2\2\u015e\u015f\7\4\2\2\u015f\u0160\5$\23\2\u0160\u0161\7"+
		"\5\2\2\u0161\u0162\5$\23\2\u0162\u0163\7\22\2\2\u0163\u0164\5$\23\2\u0164"+
		"K\3\2\2\2\u0165\u0166\t\7\2\2\u0166M\3\2\2\2\u0167\u0168\b(\1\2\u0168"+
		"\u0170\5X-\2\u0169\u016a\7\4\2\2\u016a\u016b\5T+\2\u016b\u016c\7\5\2\2"+
		"\u016c\u016d\7%\2\2\u016d\u016e\5N(\3\u016e\u0170\3\2\2\2\u016f\u0167"+
		"\3\2\2\2\u016f\u0169\3\2\2\2\u0170\u0175\3\2\2\2\u0171\u0172\f\4\2\2\u0172"+
		"\u0174\7$\2\2\u0173\u0171\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2"+
		"\2\2\u0175\u0176\3\2\2\2\u0176O\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179"+
		"\5$\23\2\u0179\u017a\7\b\2\2\u017a\u017c\3\2\2\2\u017b\u0178\3\2\2\2\u017c"+
		"\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0181\3\2"+
		"\2\2\u017f\u017d\3\2\2\2\u0180\u0182\5$\23\2\u0181\u0180\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182Q\3\2\2\2\u0183\u0184\5X-\2\u0184\u0185\7\b\2\2\u0185"+
		"\u0187\3\2\2\2\u0186\u0183\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2"+
		"\2\2\u0188\u0189\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018b"+
		"\u018d\5X-\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018dS\3\2\2\2\u018e"+
		"\u018f\5N(\2\u018f\u0190\7\b\2\2\u0190\u0192\3\2\2\2\u0191\u018e\3\2\2"+
		"\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0198"+
		"\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0199\7&\2\2\u0197\u0199\5N(\2\u0198"+
		"\u0196\3\2\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199U\3\2\2\2"+
		"\u019a\u019e\7\13\2\2\u019b\u019d\5\32\16\2\u019c\u019b\3\2\2\2\u019d"+
		"\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\3\2"+
		"\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a3\7\f\2\2\u01a2\u01a4\5^\60\2\u01a3"+
		"\u01a2\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a7\5\32"+
		"\16\2\u01a6\u019a\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7W\3\2\2\2\u01a8\u01a9"+
		"\7\60\2\2\u01a9Y\3\2\2\2\u01aa\u01ab\7/\2\2\u01ab[\3\2\2\2\u01ac\u01ad"+
		"\t\b\2\2\u01ad]\3\2\2\2\u01ae\u01b0\7)\2\2\u01af\u01ae\3\2\2\2\u01b0\u01b1"+
		"\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2_\3\2\2\2\60cip"+
		"z\u0087\u008a\u008c\u0097\u009b\u00a3\u00a5\u00ad\u00b2\u00b9\u00bc\u00c3"+
		"\u00c8\u00cf\u00d6\u00e0\u00e4\u00e9\u00ef\u00fe\u010b\u0110\u0116\u011c"+
		"\u0122\u0128\u012d\u0136\u0141\u0150\u016f\u0175\u017d\u0181\u0188\u018c"+
		"\u0193\u0198\u019e\u01a3\u01a6\u01b1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}