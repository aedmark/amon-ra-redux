;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use Window)
(use System)

(local
	yesI
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp3 (+ (/ (- (param1 sel_9:) (param1 sel_7:)) 2) (param1 sel_7:)))
	(= temp2 param2)
	(while (>= (Abs (- temp2 param3)) 4)
		(if
			(= temp0
				(self
					sel_120:
						218
						((= temp1 (Event sel_109:))
							sel_1: temp3
							sel_0: temp2
							sel_117:
						)
				)
			)
			(temp1 sel_111:)
			(return temp0)
		)
		(temp1 sel_111:)
		(if (< param2 param3)
			(+= temp2 4)
		else
			(-= temp2 4)
		)
	)
)

(class InvI of IconI
	(properties
		sel_20 {InvI}
		sel_2 0
		sel_3 0
		sel_4 0
		sel_6 0
		sel_33 999
		sel_37 0
		sel_14 0
		sel_166 0
		sel_142 0
		sel_74 0
	)

	(method (sel_216 &tmp [temp0 4])
		(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
	)

	(method (sel_217 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== sel_211 -1)
			(return)
		)
		(= temp4 (if (and argc param1) sel_211 else sel_212))
		(= temp0 (- sel_6 2))
		(= temp1 (- sel_7 2))
		(= temp2 (+ sel_8 1))
		(= temp3 (+ sel_9 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- sel_6 2) (- sel_7 2) (+ sel_8 2) (+ sel_9 2) 1)
	)

	(method (sel_218 param1)
		(return
			(if (super sel_218: param1)
				(not (& sel_14 $0004))
			else
				0
			)
		)
	)

	(method (sel_353 param1)
		(return (== sel_166 param1))
	)

	(method (sel_182 param1)
		(= sel_166 param1)
		(if (and sel_74 (== param1 gEgo))
			(gGame sel_388: sel_74)
			(= sel_74 0)
		)
		(return self)
	)

	(method (sel_300 param1)
		(if (not sel_214)
			(= sel_214 gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET sel_214 sel_213 param1 0 1))
			(gMessager sel_295: sel_213 param1 0 0 0 sel_214)
		)
	)
)

(class Inv of IconBar
	(properties
		sel_20 {Inv}
		sel_389 {You are carrying:}
		sel_55 0
		sel_390 {nothing!}
		sel_391 0
		sel_392 0
		sel_393 0
	)

	(method (sel_110)
		(= sel_55 sel_389)
	)

	(method (sel_57 &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8 temp9 [temp10 50])
		(if (gSystemWindow sel_116: 236)
			(= temp7 (gSystemWindow sel_236:))
			(gSystemWindow sel_236: 1)
		)
		(while ((= temp1 (Event sel_109:)) sel_31:)
			(temp1 sel_111:)
		)
		(temp1 sel_111:)
		(= temp1 0)
		(while (& sel_29 $0020)
			(invEvent
				sel_31: 0
				sel_37: 0
				sel_61: 0
				sel_0: 0
				sel_1: 0
				sel_73: 0
				sel_147: 0
			)
			(GetEvent evALL_EVENTS invEvent)
			(= gMouseX (invEvent sel_1:))
			(= gMouseY (invEvent sel_0:))
			(= temp9 0)
			(invEvent sel_148:)
			(if
				(and
					sel_207
					(not (invEvent sel_61:))
					(!= sel_207 sel_393)
					(or
						(== (invEvent sel_31:) 1)
						(and
							(== (invEvent sel_31:) 4)
							(== (invEvent sel_37:) 13)
							(= temp9 1)
						)
						(and (== (invEvent sel_31:) 256) (= temp9 1))
					)
					(or (!= sel_207 sel_227) (& (sel_227 sel_14:) $0010))
				)
				(invEvent sel_31: 16384 sel_37: (sel_207 sel_37:))
			)
			(MapKeyToDir invEvent)
			(= temp2 (invEvent sel_31:))
			(cond
				(gFastCast
					(gFastCast sel_133: invEvent)
				)
				((and (== temp2 1) (invEvent sel_61:))
					(self sel_231:)
					(invEvent sel_73: 1)
				)
				(
					(and
						(== temp2 0)
						(= temp0 (self sel_120: 218 invEvent))
						(!= temp0 sel_223)
					)
					(self sel_217: temp0)
				)
				(
					(or
						(== temp2 1)
						(and (== temp2 4) (== (invEvent sel_37:) 13))
						(== temp2 256)
					)
					(if
						(and
							(IsObject sel_223)
							(self sel_178: sel_223 (== temp2 1))
						)
						(cond
							((== sel_223 sel_392)
								(break)
							)
							((== sel_223 sel_227)
								(if (!= (sel_223 sel_33:) -1)
									(gGame sel_197: (sel_227 sel_33:))
								)
								(cond
									((& sel_29 $0800)
										(self sel_234:)
									)
									(sel_227
										(sel_227
											sel_14: (| (sel_227 sel_14:) $0010)
										)
									)
								)
							)
							(else
								(= sel_207 sel_223)
								(gGame sel_197: (sel_207 sel_33:))
							)
						)
					)
				)
				((& temp2 $0040)
					(switch (invEvent sel_37:)
						(3
							(self sel_190:)
						)
						(7
							(self sel_191:)
						)
						(1
							(if
								(and
									sel_223
									(= temp0
										(localproc_0
											sel_223
											(- (sel_223 sel_6:) 1)
											0
										)
									)
								)
								(self sel_217: temp0 1)
							else
								(self sel_191:)
							)
						)
						(5
							(if
								(and
									sel_223
									(= temp0
										(localproc_0
											sel_223
											(+ (sel_223 sel_8:) 1)
											(sel_32 sel_195:)
										)
									)
								)
								(self sel_217: temp0 1)
							else
								(self sel_190:)
							)
						)
						(0
							(if (& temp2 $0004)
								(self sel_231:)
							)
						)
					)
				)
				((== temp2 4)
					(switch (invEvent sel_37:)
						(9
							(self sel_190:)
						)
						(3840
							(self sel_191:)
						)
					)
				)
				((and (& temp2 $4000) (= temp0 (self sel_120: 218 invEvent)))
					(cond
						((& temp2 $2000)
							(if
								(and
									temp0
									(temp0 sel_213:)
									(Message
										msgGET
										(temp0 sel_214:)
										(temp0 sel_213:)
										(temp0 sel_215:)
										0
										1
										@temp10
									)
								)
								(if (gSystemWindow sel_116: 236)
									(= temp6 (gSystemWindow sel_236:))
									(gSystemWindow sel_236: 1)
									(Prints @temp10)
									(gSystemWindow sel_236: temp6)
								else
									(Prints @temp10)
								)
							)
							(sel_227 sel_14: (& (sel_227 sel_14:) $ffef))
							(gGame sel_197: 999)
						)
						((== temp0 sel_392)
							(break)
						)
						((not (temp0 sel_114: InvI))
							(if (self sel_178: temp0 (not temp9))
								(= sel_207 temp0)
								(gGame sel_197: (sel_207 sel_33:))
								(if (== temp0 sel_227)
									(if (& sel_29 $0800)
										(self sel_234:)
									else
										(sel_227
											sel_14: (| (sel_227 sel_14:) $0010)
										)
									)
								)
							)
						)
						(sel_207
							(if (gSystemWindow sel_116: 236)
								(= temp6 (gSystemWindow sel_236:))
								(gSystemWindow sel_236: 1)
							)
							(if (sel_207 sel_114: InvI)
								(temp0 sel_300: (sel_207 sel_37:))
							else
								(temp0 sel_300: (invEvent sel_37:))
							)
							(if (gSystemWindow sel_116: 236)
								(gSystemWindow sel_236: temp6)
							)
						)
					)
				)
			)
			(invEvent sel_111:)
		)
		(invEvent sel_111:)
		(if (gSystemWindow sel_116: 236)
			(gSystemWindow sel_236: temp7)
		)
		(self sel_102:)
	)

	(method (sel_113 param1)
		(gSounds sel_168:)
		(if (and gPMouse (gPMouse sel_116: 167))
			(gPMouse sel_167:)
		)
		(if (gTheIconBar sel_220:)
			(gTheIconBar sel_102:)
		)
		(if (not sel_32)
			(= sel_32 (SysWindow sel_109:))
		)
		(if (sel_32 sel_32:)
			(sel_32 sel_111:)
			(= sel_32 0)
		)
		(if (not sel_392)
			(= sel_392 (NodeValue (self sel_124:)))
		)
		(= sel_207 0)
		(if (self sel_216: (if argc param1 else gEgo))
			(self sel_57:)
		)
	)

	(method (sel_216 param1 &tmp temp0 temp1)
		(gGame
			sel_197:
				(if sel_207
					(sel_207 sel_33:)
				else
					(sel_393 sel_33:)
				)
		)
		(= temp0 (PicNotValid))
		(PicNotValid 0)
		(|= sel_29 $0020)
		(if
			(not
				(= temp1
					(self
						sel_394:
							(if argc param1 else gEgo)
							(gTheIconBar sel_207:)
					)
				)
			)
			(&= sel_29 $ffdf)
		)
		(PicNotValid temp0)
		(return temp1)
	)

	(method (sel_102 &tmp temp0)
		(if (& sel_29 $0020)
			(gSounds sel_168: 0)
			(&= sel_29 $ffdf)
		)
		(if sel_32
			(sel_32 sel_111:)
		)
		(if (and (IsObject sel_207) (sel_207 sel_114: InvI))
			(if (not (gTheIconBar sel_225:))
				(gTheIconBar sel_177: (gTheIconBar sel_226:))
			)
			(gTheIconBar
				sel_207:
					((gTheIconBar sel_226:) sel_33: (sel_207 sel_33:) sel_117:)
				sel_225: sel_207
			)
			(if (= temp0 ((gTheIconBar sel_207:) sel_33:))
				(gGame sel_197: temp0)
			)
		)
	)

	(method (sel_190 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(for
			((= temp3 (+ temp1 (= temp2 (self sel_132: sel_223)))))
			1
			((++ temp3))

			(= temp0
				(self
					sel_64:
						(if (<= temp3 sel_86)
							temp3
						else
							(mod temp3 (- sel_86 1))
						)
				)
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_124:)))
			)
			(if (not (& (temp0 sel_14:) $0004))
				(break)
			)
		)
		(self sel_217: temp0 1)
	)

	(method (sel_191 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(for
			((= temp3 (- (= temp2 (self sel_132: sel_223)) temp1)))
			1
			((-- temp3))

			(= temp0 (self sel_64: temp3))
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_127:)))
			)
			(if (not (& (temp0 sel_14:) $0004))
				(break)
			)
		)
		(self sel_217: temp0 1)
	)

	(method (sel_353 param1)
		(self sel_120: 353 param1)
	)

	(method (sel_394 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 [temp22 50])
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for ((= temp8 (self sel_124:))) temp8 ((= temp8 (self sel_65: temp8)))
			(if ((= temp9 (NodeValue temp8)) sel_114: InvI)
				(if (temp9 sel_353: param1)
					(temp9 sel_14: (& (temp9 sel_14:) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide
									(temp9 sel_2:)
									(temp9 sel_3:)
									(temp9 sel_4:)
								)
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh
									(temp9 sel_2:)
									(temp9 sel_3:)
									(temp9 sel_4:)
								)
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 sel_14: (| (temp9 sel_14:) $0004))
				)
			else
				(++ temp3)
				(+=
					temp5
					(CelWide (temp9 sel_2:) (temp9 sel_3:) (temp9 sel_4:))
				)
				(if
					(>
						(= temp7
							(CelHigh
								(temp9 sel_2:)
								(temp9 sel_3:)
								(temp9 sel_4:)
							)
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
		)
		(if (not temp0)
			(Print sel_199: @temp22 {%s %s} sel_389 sel_390 sel_110:)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3)
			(= temp16 3)
		)
		(if (< (* temp16 (= yesI (/ temp0 temp16))) temp0)
			(++ yesI)
		)
		(= temp10 (Max (+ 4 temp5) (* yesI (+ 4 temp2))))
		(= temp12 (/ (- 190 (= temp11 (* temp16 (+ 4 temp1)))) 2))
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= temp21 (self sel_32:))
			(temp21
				sel_193: temp12
				sel_194: temp13
				sel_196: temp15
				sel_195: temp14
				sel_189:
			)
		)
		(= temp20 yesI)
		(if temp0
			(= temp18
				(+
					2
					(if (temp21 sel_116: 385)
						(temp21 sel_385:)
					else
						0
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if (temp21 sel_116: 384)
							(temp21 sel_384:)
						else
							0
						)
					)
				)
			)
			(for
				((= temp8 (self sel_124:)))
				temp8
				((= temp8 (self sel_65: temp8)))

				(if
					(and
						(not (& ((= temp9 (NodeValue temp8)) sel_14:) $0004))
						(temp9 sel_114: InvI)
					)
					(if (not (& (temp9 sel_14:) $0080))
						(temp9
							sel_7:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide
													(temp9 sel_2:)
													(temp9 sel_3:)
													(temp9 sel_4:)
												)
											)
										)
										2
									)
								)
							sel_6:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh
													(temp9 sel_2:)
													(temp9 sel_3:)
													(temp9 sel_4:)
												)
											)
										)
										2
									)
								)
						)
						(temp9
							sel_9: (+ (temp9 sel_7:) temp6)
							sel_8: (+ (temp9 sel_6:) temp7)
						)
						(if (-- temp20)
							(+= temp17 temp2)
						else
							(= temp20 yesI)
							(+= temp18 temp1)
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 sel_7:))
						(= temp18 (temp9 sel_6:))
					)
					(temp9 sel_216:)
					(if (== temp9 param2)
						(temp9 sel_217:)
					)
				)
			)
		)
		(= temp17 (/ (- (- (temp21 sel_196:) (temp21 sel_194:)) temp5) 2))
		(= temp11 (- (temp21 sel_195:) (temp21 sel_193:)))
		(= temp18 32767)
		(for ((= temp8 (self sel_124:))) temp8 ((= temp8 (self sel_65: temp8)))
			(if (not ((= temp9 (NodeValue temp8)) sel_114: InvI))
				(= temp6 (CelWide (temp9 sel_2:) (temp9 sel_3:) (temp9 sel_4:)))
				(= temp7 (CelHigh (temp9 sel_2:) (temp9 sel_3:) (temp9 sel_4:)))
				(if (not (& (temp9 sel_14:) $0080))
					(if (== temp18 32767)
						(= temp18 (- temp11 temp7))
					)
					(temp9
						sel_7: temp17
						sel_6: temp18
						sel_8: temp11
						sel_9: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 sel_7:) temp6))
				(= temp18 (temp9 sel_6:))
				(temp9 sel_14: (& (temp9 sel_14:) $fffb) sel_216:)
			)
		)
		(return 1)
	)
)

(instance invEvent of Event
	(properties
		sel_20 {invEvent}
	)
)
