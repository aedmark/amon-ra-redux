;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 921)
(include sci.sh)
(use Main)
(use Interface)
(use Dialog)
(use System)

(public
	Prints 0
	Printf 1
	GetInput 2
)

(procedure (Prints)
	(Print sel_198: &rest sel_110:)
)

(procedure (Printf)
	(Print sel_199: &rest sel_110:)
)

(procedure (GetInput str maxLen prompt theFont)
	(if
		(Print
			sel_30: (if (> argc 3) theFont else 0)
			sel_198: (if (and (> argc 2) prompt) prompt else {})
			sel_200: str maxLen 0 12 str
			sel_110:
		)
		(StrLen str)
	)
)

(class Print of Obj
	(properties
		sel_20 {Print}
		sel_201 0
		sel_32 0
		sel_77 0
		sel_27 0
		sel_30 0
		sel_67 0
		sel_1 -1
		sel_0 -1
		sel_139 0
		sel_143 0
		sel_202 0
		sel_203 0
		sel_124 0
		sel_204 0
	)

	(method (sel_110 param1)
		(= sel_143 0)
		(if argc
			(= sel_143 param1)
		)
		(if (> argc 1)
			(self sel_198: &rest)
		)
		(if (not sel_203)
			(if (not (IsObject gPrints))
				(= gPrints ((EventHandler sel_109:) sel_20: {prints}))
			)
			(gPrints sel_118: self)
		)
		(self sel_113:)
	)

	(method (sel_57)
		(sel_201 sel_119: 57)
	)

	(method (sel_111)
		(if (and gPrints (gPrints sel_122: self))
			(gPrints sel_81: self)
			(if (gPrints sel_123:)
				(gPrints sel_111:)
				(= gPrints 0)
			)
		)
		(= sel_77 (= sel_124 (= sel_204 (= sel_32 0))))
		(= sel_30 gUserFont)
		(= sel_67 (= sel_27 0))
		(= sel_1 (= sel_0 -1))
		(= sel_203 0)
		(gSounds sel_168: 0)
		(super sel_111:)
	)

	(method (sel_113 &tmp temp0 temp1 temp2 temp3 temp4)
		(if sel_204
			(gGame sel_197: 999)
		)
		(if (not sel_201)
			(= sel_201 (Dialog sel_109:))
		)
		(sel_201
			sel_32: (if sel_32 sel_32 else gSystemWindow)
			sel_20: {PODialog}
			sel_143: self
		)
		(sel_201 sel_23: sel_77 sel_22: sel_139 sel_180:)
		(sel_201 sel_192:)
		(= temp3
			(if (== sel_1 -1)
				(sel_201 sel_7:)
			else
				sel_1
			)
		)
		(= temp4
			(if (== sel_0 -1)
				(sel_201 sel_6:)
			else
				sel_0
			)
		)
		(sel_201 sel_182: temp3 temp4)
		(= temp1 (GetPort))
		(sel_201 sel_189: (if sel_77 4 else 0) 15)
		(if sel_203
			(= gModelessPort (GetPort))
			(SetPort temp1)
			(= gModelessDialog sel_201)
		else
			(gSounds sel_168: 1)
			(cond
				((not (= temp0 sel_124))
					(if
						(and
							(= temp0 (sel_201 sel_120: 185 1))
							(not (sel_201 sel_120: 185 2))
						)
						(temp0 sel_29: (| (temp0 sel_29:) $0002))
					)
				)
				((not (IsObject temp0))
					(= temp0 (sel_201 sel_64: temp0))
				)
			)
			(= sel_202 (sel_201 sel_57: temp0))
			(SetPort temp1)
			(cond
				((== sel_202 -1)
					(= sel_202 0)
				)
				((and (IsObject sel_202) (sel_202 sel_114: DButton))
					(= sel_202 (sel_202 sel_74:))
				)
				((not (sel_201 sel_187:))
					(= sel_202 1)
				)
			)
			(if sel_204
				(gGame sel_197: ((gTheIconBar sel_207:) sel_33:))
			)
			(sel_201 sel_111:)
			(return sel_202)
		)
	)

	(method (sel_205 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (not sel_201)
			(= sel_201 (Dialog sel_109:))
		)
		(if (> argc 4)
			(= temp0 param2)
			(= temp1 param3)
			(= temp2 param4)
			(= temp3 (if param5 param5 else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (> argc 5)
				(= temp4 param6)
				(if (> argc 6)
					(= temp5 param7)
					(if (> argc 7)
						(= temp6 param8)
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (not (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7))
					(= temp7 0)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (> argc 2)
				(= temp4 param3)
				(if (> argc 3)
					(= temp5 param4)
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen param2) 1)))
			(StrCpy temp7 param2)
		)
		(if temp7
			(sel_201
				sel_118:
					((DButton sel_109:)
						sel_74: param1
						sel_30: sel_30
						sel_23: temp7
						sel_180:
						sel_182: (+ 4 temp4) (+ 4 temp5)
						sel_117:
					)
				sel_180:
			)
		)
	)

	(method (sel_200 param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not sel_201)
			(= sel_201 (Dialog sel_109:))
		)
		(StrCpy param1 (if (> argc 4) param5 else {}))
		(if (> argc 2)
			(= temp0 param3)
			(if (> argc 3)
				(= temp1 param4)
			)
		)
		(sel_201
			sel_118:
				((DEdit sel_109:)
					sel_23: param1
					sel_34: param2
					sel_180:
					sel_182: (+ temp0 4) (+ temp1 4)
					sel_117:
				)
			sel_180:
		)
	)

	(method (sel_206 param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not sel_201)
			(= sel_201 (Dialog sel_109:))
		)
		(if (> argc 3)
			(= temp0 param4)
			(= temp1 param5)
		else
			(= temp0 (= temp1 0))
		)
		(if (IsObject param1)
			(sel_201
				sel_118:
					(param1 sel_180: sel_182: (+ temp0 4) (+ temp1 4) sel_117:)
				sel_180:
			)
		else
			(sel_201
				sel_118:
					((DIcon sel_109:)
						sel_2: param1
						sel_3: param2
						sel_4: param3
						sel_180:
						sel_182: (+ temp0 4) (+ temp1 4)
						sel_117:
					)
				sel_180:
			)
		)
	)

	(method (sel_198 param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (not sel_201)
			(= sel_201 (Dialog sel_109:))
		)
		(if (> argc 3)
			(= temp0 param1)
			(= temp1 param2)
			(= temp2 param3)
			(= temp3 (if param4 param4 else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (>= argc 5)
				(= temp4 param5)
				(if (>= argc 6)
					(= temp5 param6)
					(if (>= argc 7)
						(= temp6 param7)
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7)
					(sel_201
						sel_118:
							((DText sel_109:)
								sel_23: temp7
								sel_30: sel_30
								sel_27: sel_27
								sel_180: sel_67
								sel_182: (+ 4 temp4) (+ 4 temp5)
								sel_117:
							)
						sel_180:
					)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (>= argc 2)
				(= temp4 param2)
				(if (>= argc 3)
					(= temp5 param3)
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen param1) 1)))
			(StrCpy temp7 param1)
			(sel_201
				sel_118:
					((DText sel_109:)
						sel_23: temp7
						sel_30: sel_30
						sel_27: sel_27
						sel_180: sel_67
						sel_182: (+ 4 temp4) (+ 4 temp5)
						sel_117:
					)
				sel_180:
			)
		)
	)

	(method (sel_199 param1)
		(Format param1 &rest)
		(self sel_198: param1)
	)

	(method (sel_153 param1 param2)
		(= sel_1 param1)
		(= sel_0 param2)
	)

	(method (sel_133 param1)
		(if (sel_201 sel_133: param1)
			(sel_201 sel_111:)
		)
	)

	(method (sel_145 &tmp temp0)
		(= temp0 sel_143)
		(= sel_201 0)
		(if sel_32
			(sel_32 sel_111:)
		)
		(self sel_111:)
		(if temp0
			(temp0 sel_145:)
		)
	)
)
