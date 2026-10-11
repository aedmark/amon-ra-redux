;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class IconI of Obj
	(properties
		sel_20 {IconI}
		sel_2 -1
		sel_3 -1
		sel_4 -1
		sel_7 0
		sel_6 -1
		sel_9 0
		sel_8 0
		sel_29 0
		sel_33 -1
		sel_31 16384
		sel_37 -1
		sel_61 0
		sel_14 1
		sel_208 0
		sel_209 0
		sel_210 0
		sel_211 0
		sel_212 0
		sel_213 0
		sel_214 0
		sel_215 0
	)

	(method (sel_216 param1 param2 &tmp [temp0 7])
		(|= sel_14 $0020)
		(if argc
			(= sel_9 (+ (= sel_7 param1) (CelWide sel_2 sel_3 sel_4)))
			(= sel_8 (+ (= sel_6 param2) (CelHigh sel_2 sel_3 sel_4)))
		else
			(= sel_9 (+ sel_7 (CelWide sel_2 sel_3 sel_4)))
			(= sel_8 (+ sel_6 (CelHigh sel_2 sel_3 sel_4)))
		)
		(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
		(if (& sel_14 $0004)
			(self sel_219:)
		)
		(if (and gPMouse (gPMouse sel_116: 167))
			(gPMouse sel_167:)
		)
	)

	(method (sel_178 param1 &tmp temp0 temp1)
		(return
			(cond
				((& sel_14 $0004) 0)
				((and argc param1 (& sel_14 $0001))
					(DrawCel sel_2 sel_3 (= temp1 1) sel_7 sel_6 -1)
					(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					(while (!= ((= temp0 (Event sel_109:)) sel_31:) 2)
						(temp0 sel_148:)
						(cond
							((self sel_218: temp0)
								(if (not temp1)
									(DrawCel
										sel_2
										sel_3
										(= temp1 1)
										sel_7
										sel_6
										-1
									)
									(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
								)
							)
							(temp1
								(DrawCel sel_2 sel_3 (= temp1 0) sel_7 sel_6 -1)
								(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
							)
						)
						(temp0 sel_111:)
					)
					(temp0 sel_111:)
					(if (== temp1 1)
						(DrawCel sel_2 sel_3 0 sel_7 sel_6 -1)
						(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)

	(method (sel_217 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or (not (& sel_14 $0020)) (== sel_211 -1))
			(return)
		)
		(= temp4 (if (and argc param1) sel_211 else sel_212))
		(= temp0 (+ sel_6 2))
		(= temp1 (+ sel_7 2))
		(= temp2 (- sel_8 3))
		(= temp3 (- sel_9 4))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- sel_6 2) (- sel_7 2) sel_8 (+ sel_9 3) 1)
	)

	(method (sel_218 param1)
		(return
			(if
				(and
					(>= (param1 sel_1:) sel_7)
					(>= (param1 sel_0:) sel_6)
					(<= (param1 sel_1:) sel_9)
				)
				(<= (param1 sel_0:) sel_8)
			else
				0
			)
		)
	)

	(method (sel_219)
		(DrawCel
			sel_208
			sel_209
			sel_210
			(+
				sel_7
				(/
					(-
						(CelWide sel_2 sel_3 sel_4)
						(CelWide sel_208 sel_209 sel_210)
					)
					2
				)
			)
			(+
				sel_6
				(/
					(-
						(CelHigh sel_2 sel_3 sel_4)
						(CelHigh sel_208 sel_209 sel_210)
					)
					2
				)
			)
			-1
		)
	)
)

(class IconBar of Set
	(properties
		sel_20 {IconBar}
		sel_220 0
		sel_5 0
		sel_221 0
		sel_222 0
		sel_207 0
		sel_223 0
		sel_224 0
		sel_225 0
		sel_226 0
		sel_227 0
		sel_228 0
		sel_147 0
		sel_32 0
		sel_29 1024
		sel_229 0
		sel_0 0
	)

	(method (sel_57 &tmp temp0 temp1 temp2 temp3)
		(while (and (& sel_29 $0020) (= temp0 (Event sel_109:)))
			(= temp1 (temp0 sel_31:))
			(= temp2 (temp0 sel_37:))
			(= temp3 (temp0 sel_61:))
			(Wait 1)
			(if (== temp1 256)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 sel_31: temp1 sel_37: temp2 sel_61: temp3)
			)
			(temp0 sel_148:)
			(if
				(and
					(or (== temp1 1) (and (== temp1 4) (== temp2 13)))
					(IsObject sel_227)
					(& (sel_227 sel_14:) $0010)
				)
				(temp0 sel_31: 24576 sel_37: (sel_227 sel_37:))
			)
			(MapKeyToDir temp0)
			(if (self sel_232: temp0)
				(break)
			)
		)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(param1 sel_148:)
		(= temp1 (param1 sel_31:))
		(cond
			((& sel_29 $0004))
			(
				(or
					(and
						(not temp1)
						(& sel_29 $0400)
						(<= -10 (param1 sel_0:))
						(<= (param1 sel_0:) sel_220)
						(<= 0 (param1 sel_1:))
						(<= (param1 sel_1:) 320)
						(not (= temp0 0))
					)
					(and
						(== temp1 4)
						(or
							(== (param1 sel_37:) 27)
							(== (param1 sel_37:) 21248)
						)
						(= temp0 1)
					)
				)
				(param1 sel_149:)
				(= sel_221 (param1 sel_1:))
				(= sel_222 (param1 sel_0:))
				(= temp2 gTheCursor)
				(= temp3 sel_207)
				(= temp4 sel_225)
				(self sel_216:)
				(gGame sel_197: 999)
				(if temp0
					(gGame
						sel_197:
							gTheCursor
							1
							(+
								(sel_207 sel_7:)
								(/ (- (sel_207 sel_9:) (sel_207 sel_7:)) 2)
							)
							(- (sel_207 sel_8:) 3)
					)
				)
				(self sel_57:)
				(if temp0
					(gGame
						sel_197:
							(if
								(and
									(not (gUser sel_347:))
									(not (gUser sel_237:))
								)
								997
							else
								(sel_207 sel_33:)
							)
							1
							sel_221
							sel_222
					)
				else
					(gGame
						sel_197:
							(if
								(and
									(not (gUser sel_347:))
									(not (gUser sel_237:))
								)
								997
							else
								(sel_207 sel_33:)
							)
							1
							((= temp5 (Event sel_109:)) sel_1:)
							(Max (temp5 sel_0:) (+ 1 sel_220))
					)
					(temp5 sel_111:)
				)
				(self sel_102:)
			)
			((& temp1 $0004)
				(switch (param1 sel_37:)
					(13
						(if (IsObject sel_207)
							(param1
								sel_31: (sel_207 sel_31:)
								sel_37:
									(if (== sel_207 sel_226)
										(sel_225 sel_37:)
									else
										(sel_207 sel_37:)
									)
							)
						)
					)
					(20992
						(if (gUser sel_237:)
							(self sel_230:)
						)
						(param1 sel_73: 1)
					)
					(0
						(if (& (param1 sel_31:) $0040)
							(self sel_231:)
							(param1 sel_73: 1)
						)
					)
				)
			)
			((& temp1 $0001)
				(cond
					((& (param1 sel_61:) $0003)
						(self sel_231:)
						(param1 sel_73: 1)
					)
					((& (param1 sel_61:) $0004)
						(if (gUser sel_237:)
							(self sel_230:)
						)
						(param1 sel_73: 1)
					)
					((IsObject sel_207)
						(param1
							sel_31: (sel_207 sel_31:)
							sel_37:
								(if (== sel_207 sel_226)
									(sel_225 sel_37:)
								else
									(sel_207 sel_37:)
								)
						)
					)
				)
			)
		)
	)

	(method (sel_216 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gSounds sel_168:)
		(|= sel_29 $0020)
		(gGame sel_197: 999 1)
		(= sel_220
			(CelHigh
				((= temp0 (self sel_64: 0)) sel_2:)
				(temp0 sel_3:)
				(temp0 sel_4:)
			)
		)
		(= sel_147 (GetPort))
		(SetPort -1)
		(= sel_5 (Graph grSAVE_BOX sel_0 0 (+ sel_0 sel_220) 320 1))
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= temp3 0)
		(= temp4 sel_0)
		(for ((= temp5 (FirstNode sel_24))) temp5 ((= temp5 temp6))
			(= temp6 (NextNode temp5))
			(if (not (IsObject (= temp7 (NodeValue temp5))))
				(return)
			)
			(if (<= (temp7 sel_9:) 0)
				(temp7 sel_216: temp3 temp4)
				(= temp3 (temp7 sel_9:))
			else
				(temp7 sel_216:)
			)
		)
		(if sel_225
			(if (gEgo sel_238: (gInventory sel_132: sel_225))
				(= temp3
					(+
						(/
							(-
								(- (sel_226 sel_9:) (sel_226 sel_7:))
								(CelWide
									(sel_225 sel_2:)
									(+ (sel_225 sel_3:) 1)
									(sel_225 sel_4:)
								)
							)
							2
						)
						(sel_226 sel_7:)
					)
				)
				(= temp4
					(+
						sel_0
						(/
							(-
								(- (sel_226 sel_8:) (sel_226 sel_6:))
								(CelHigh
									(sel_225 sel_2:)
									(+ (sel_225 sel_3:) 1)
									(sel_225 sel_4:)
								)
							)
							2
						)
						(sel_226 sel_6:)
					)
				)
				(DrawCel
					(sel_225 sel_2:)
					(+ (sel_225 sel_3:) 1)
					(sel_225 sel_4:)
					temp3
					temp4
					-1
				)
				(if (& (sel_226 sel_14:) $0004)
					(sel_226 sel_219:)
				)
			else
				(= sel_225 0)
			)
		)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX sel_0 0 (+ sel_0 sel_220) 320 1)
		(self sel_217: sel_207)
	)

	(method (sel_102 &tmp temp0 temp1 temp2)
		(if (& sel_29 $0020)
			(gSounds sel_168: 0)
			(&= sel_29 $ffdf)
			(for ((= temp0 (FirstNode sel_24))) temp0 ((= temp0 temp1))
				(= temp1 (NextNode temp0))
				(if (not (IsObject (= temp2 (NodeValue temp0))))
					(return)
				)
				((= temp2 (NodeValue temp0)) sel_14: (& (temp2 sel_14:) $ffdf))
			)
			(Graph grRESTORE_BOX sel_5)
			(Graph grUPDATE_BOX sel_0 0 (+ sel_0 sel_220) 320 1)
			(Graph grREDRAW_BOX sel_0 0 (+ sel_0 sel_220) 320)
			(SetPort sel_147)
			(= sel_220 sel_229)
		)
	)

	(method (sel_190 &tmp temp0 temp1)
		(for
			((= temp1 1))
			(<= temp1 sel_86)
			((= temp1 (mod (+ temp1 1) sel_86)))

			(= temp0
				(self sel_64: (mod (+ temp1 (self sel_132: sel_223)) sel_86))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_124:)))
			)
			(if (not (& (temp0 sel_14:) $0004))
				(break)
			)
		)
		(self sel_217: temp0 (& sel_29 $0020))
	)

	(method (sel_191 &tmp temp0 temp1)
		(for
			((= temp1 1))
			(<= temp1 sel_86)
			((= temp1 (mod (+ temp1 1) sel_86)))

			(= temp0
				(self sel_64: (mod (- (self sel_132: sel_223) temp1) sel_86))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_127:)))
			)
			(if (not (& (temp0 sel_14:) $0004))
				(break)
			)
		)
		(self sel_217: temp0 (& sel_29 $0020))
	)

	(method (sel_178 param1 param2)
		(return
			(if (param1 sel_178: (and (>= argc 2) param2))
				(if (not (& (param1 sel_14:) $0002))
					(= sel_207 param1)
				)
				1
			else
				0
			)
		)
	)

	(method (sel_217 param1 param2 &tmp temp0)
		(if (not (& (param1 sel_14:) $0004))
			(if (IsObject sel_223)
				(sel_223 sel_217: 0)
			)
			((= sel_223 param1) sel_217: 1)
		)
		(if (and (>= argc 2) param2)
			(gGame
				sel_197:
					gTheCursor
					1
					(+
						(param1 sel_7:)
						(/ (- (param1 sel_9:) (param1 sel_7:)) 2)
					)
					(- (param1 sel_8:) 3)
			)
		)
	)

	(method (sel_230 &tmp temp0)
		(cond
			((& sel_29 $0004)
				(return)
			)
			(
				(and
					(!= sel_207 (= temp0 (NodeValue (self sel_124:))))
					(not (& (temp0 sel_14:) $0004))
				)
				(= sel_224 sel_207)
				(= sel_207 (NodeValue (self sel_124:)))
			)
			((and sel_224 (not (& (sel_224 sel_14:) $0004)))
				(= sel_207 sel_224)
			)
		)
		(gGame sel_197: (sel_207 sel_33:) 1)
	)

	(method (sel_231 &tmp temp0 temp1 temp2)
		(if (& sel_29 $0004)
			(return)
		)
		(= temp0 sel_207)
		(= temp1 0)
		(while
			(&
				((= temp0
						(self sel_64: (mod (+ (self sel_132: temp0) 1) sel_86))
					)
					sel_14:
				)
				$0006
			)
			(if (> temp1 (+ 1 sel_86))
				(return)
			else
				(++ temp1)
			)
		)
		(= sel_207 temp0)
		(gGame sel_197: (sel_207 sel_33:) 1)
	)

	(method (sel_232 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 50] temp57 temp58 temp59)
		(= temp1 (param1 sel_1:))
		(= temp0 (param1 sel_0:))
		(= temp2 (param1 sel_31:))
		(= temp3 (param1 sel_37:))
		(= temp5 (param1 sel_73:))
		(if (= temp4 (self sel_120: 218 param1))
			(= temp57 (temp4 sel_33:))
			(= temp58 (temp4 sel_14:))
			(= temp59 (== temp4 sel_227))
		)
		(param1 sel_111:)
		(if (& temp2 $0040)
			(switch temp3
				(3
					(self sel_190:)
				)
				(7
					(self sel_191:)
				)
			)
		else
			(switch temp2
				(0
					(cond
						(
							(not
								(and
									(<= 0 temp0)
									(<= temp0 (+ sel_0 sel_220))
									(<= 0 temp1)
									(<= temp1 320)
								)
							)
							(if
								(and
									(& sel_29 $0400)
									(or
										(not (IsObject sel_227))
										(not (& (sel_227 sel_14:) $0010))
									)
								)
								(= sel_222 0)
								(= temp5 1)
							)
						)
						((and temp4 (!= temp4 sel_223))
							(= sel_222 0)
							(self sel_217: temp4)
						)
					)
				)
				(1
					(if (and temp4 (self sel_178: temp4 1))
						(if temp59
							(if temp57
								(gGame sel_197: temp57)
							)
							(if (& sel_29 $0800)
								(self sel_234:)
							else
								(sel_227 sel_14: (| (sel_227 sel_14:) $0010))
							)
						else
							(= temp5 (& temp58 $0040))
						)
						(temp4 sel_57:)
					)
				)
				(4
					(switch temp3
						(27
							(= temp5 1)
						)
						(21248
							(= temp5 1)
						)
						(13
							(if (not temp4)
								(= temp4 sel_223)
							)
							(cond
								((and temp4 (== temp4 sel_227))
									(if (!= temp57 -1)
										(gGame sel_197: temp57)
									)
									(if sel_227
										(sel_227
											sel_14: (| (sel_227 sel_14:) $0010)
										)
									)
								)
								((and (IsObject temp4) (self sel_178: temp4))
									(temp4 sel_57:)
									(= temp5 (& temp58 $0040))
								)
							)
						)
						(3840
							(self sel_191:)
						)
						(9
							(self sel_190:)
						)
					)
				)
				(24576
					(if (and temp4 (temp4 sel_215:))
						(= temp6 (GetPort))
						(Print
							sel_30: gUserFont
							sel_67: 250
							sel_198:
								(temp4 sel_213:)
								(temp4 sel_215:)
								0
								1
								0
								0
								(temp4 sel_214:)
							sel_110:
						)
						(SetPort temp6)
					)
					(if sel_227
						(sel_227 sel_14: (& (sel_227 sel_14:) $ffef))
					)
					(gGame sel_197: 999)
				)
			)
		)
		(return temp5)
	)

	(method (sel_233 param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self sel_64: [param1 temp0])
					)
				)
				(if (!= temp1 (self sel_64: 7))
					(temp1 sel_14: (| (temp1 sel_14:) $0004))
					(cond
						((== temp1 sel_207)
							(self sel_231:)
						)
						((== temp1 sel_223)
							(self sel_190:)
						)
					)
				)
			)
		else
			(|= sel_29 $0004)
		)
	)

	(method (sel_177 param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self sel_64: [param1 temp0])
					)
				)
				(temp1 sel_14: (& (temp1 sel_14:) $fffb))
			)
		else
			(&= sel_29 $fffb)
		)
	)

	(method (sel_234 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (= temp2 0))
		(= temp3 (GetPort))
		(= temp4 (gSystemWindow sel_236:))
		(gSystemWindow sel_236: 1)
		(while (not ((= temp0 (Event sel_109:)) sel_31:))
			(if (not (self sel_115: IconBar))
				(temp0 sel_148:)
			)
			(cond
				((= temp2 (self sel_120: 218 temp0))
					(if (and (!= temp2 temp1) (temp2 sel_215:))
						(= temp1 temp2)
						(if gModelessDialog
							(gModelessDialog sel_111:)
						)
						(Print
							sel_30: gUserFont
							sel_67: 250
							sel_198:
								(temp2 sel_213:)
								(temp2 sel_215:)
								0
								1
								0
								0
								(temp2 sel_214:)
							sel_203: 1
							sel_110:
						)
						(SetPort temp3)
					)
				)
				(gModelessDialog
					(gModelessDialog sel_111:)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 sel_111:)
		)
		(gSystemWindow sel_236: temp4)
		(gGame sel_197: 999 1)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(SetPort temp3)
		(if (not (sel_227 sel_218: temp0))
			(self sel_232: temp0)
		else
			(temp0 sel_111:)
		)
	)

	(method (sel_235 param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (== ((= temp1 (self sel_64: temp0)) sel_37:) param1)
				(return temp1)
			)
		)
		(return 0)
	)
)
