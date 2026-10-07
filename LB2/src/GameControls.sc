;;; Sierra Script 1.0 - (do not remove this comment)
(script# 978)
(include sci.sh)
(use Main)
(use Print)
(use IconI)


(class GameControls of IconBar
	(properties
		sel_20 {GameControls}
		sel_24 0
		sel_86 0
		sel_220 200
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
		sel_29 0
		sel_229 0
		sel_0 0
		sel_392 0
	)
	
	(method (sel_216 &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds sel_168:)
		(if (and gPseudoMouse (gPseudoMouse sel_116: 167))
			(gPseudoMouse sel_167:)
		)
		(= sel_29 (| sel_29 $0020))
		(if (IsObject sel_32)
			(sel_32 sel_189:)
		else
			(= sel_32
				((gLb2Win sel_109:)
					sel_193: 46
					sel_194: 24
					sel_195: 155
					sel_196: 296
					sel_60: 15
					sel_189:
					sel_117:
				)
			)
		)
		(= temp0 30)
		(= temp1 30)
		(= temp2 (FirstNode sel_24))
		(while temp2
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
			(if
				(and
					(not (& (temp4 sel_14?) $0080))
					(<= (temp4 sel_9?) 0)
				)
				(temp4 sel_216: temp0 temp1)
				(= temp0 (+ 20 (temp4 sel_9?)))
			else
				(temp4 sel_216:)
			)
			(= temp2 temp3)
		)
		(if (not sel_392)
			(= sel_392 (NodeValue (self sel_124:)))
		)
		(if sel_207
			(gGame
				sel_197:
					gSel_582
					1
					(+
						(sel_207 sel_7?)
						(/ (- (sel_207 sel_9?) (sel_207 sel_7?)) 2)
					)
					(- (sel_207 sel_8?) 3)
			)
		)
		(self sel_57: sel_102:)
	)
	
	(method (sel_102)
		(if sel_32 (sel_32 sel_111:) (= sel_32 0))
		(if (& sel_29 $0020)
			(gSounds sel_168: 0)
			(= sel_29 (& sel_29 $ffdf))
		)
	)
	
	(method (sel_178 param1 param2)
		(param1 sel_178: (if (>= argc 2) param2 else 0))
	)
	
	(method (sel_230)
	)
	
	(method (sel_231 &tmp temp0)
	)
	
	(method (sel_232 param1 &tmp gLb2WinSel_236 temp1 temp2 [temp3 50])
		(return
			(cond 
				((== (param1 sel_31?) 8192)
					(= temp1 (self sel_120: 218 param1))
					(param1 sel_111:)
					(if (and temp1 (temp1 sel_215?))
						(= temp2 (GetPort))
						(if (gLb2Win sel_116: 236)
							(= gLb2WinSel_236 (gLb2Win sel_236?))
							(gLb2Win sel_236: 1)
							(Print
								sel_30: gSel_30
								sel_67: 250
								sel_198: (temp1 sel_213?) (temp1 sel_215?) 0 1 0 0 (temp1 sel_214?)
								sel_110:
							)
							(gLb2Win sel_236: gLb2WinSel_236)
						else
							(Print
								sel_30: gSel_30
								sel_67: 250
								sel_198: (temp1 sel_213?) (temp1 sel_215?) 0 1 0 0 (temp1 sel_214?)
								sel_110:
							)
						)
						(SetPort temp2)
					)
					(if sel_227
						(sel_227 sel_14: (& (sel_227 sel_14?) $ffef))
					)
					(gGame sel_197: 999)
					(return 0)
				)
				((& (param1 sel_31?) $0040)
					(switch (param1 sel_37?)
						(5
							(param1 sel_111:)
							(cond 
								(
								(and (IsObject sel_223) (sel_223 sel_116: 191)) (sel_223 sel_191:) (return 0))
								(
									(or
										(not (IsObject sel_223))
										(& (sel_223 sel_14?) $0100)
									)
									(self sel_190:)
									(return 0)
								)
							)
						)
						(1
							(param1 sel_111:)
							(cond 
								(
								(and (IsObject sel_223) (sel_223 sel_116: 190)) (sel_223 sel_190:) (return 0))
								(
									(or
										(not (IsObject sel_223))
										(& (sel_223 sel_14?) $0100)
									)
									(self sel_191:)
									(return 0)
								)
							)
						)
						(else  (super sel_232: param1))
					)
				)
				(else (super sel_232: param1))
			)
		)
	)
)

(class ControlIcon of IconI
	(properties
		sel_20 {ControlIcon}
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
		sel_348 0
		sel_519 0
	)
	
	(method (sel_57)
		(if sel_348
			(if (& sel_14 $0040)
				((if gGameControls else GameControls) sel_102:)
			)
			(gGame sel_397: sel_348 sel_398: sel_519)
		)
	)
)
