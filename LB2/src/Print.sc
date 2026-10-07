;;; Sierra Script 1.0 - (do not remove this comment)
(script# 921)
(include sci.sh)
(use Main)
(use Class_255_0)
(use DIcon)
(use Obj)

(public
	proc921_0 0
	proc921_1 1
	proc921_2 2
)

(procedure (proc921_0)
	(Print sel_198: &rest sel_110:)
)

(procedure (proc921_1)
	(Print sel_199: &rest sel_110:)
)

(procedure (proc921_2 param1 param2 param3 param4)
	(if
		(Print
			sel_30: (if (> argc 3) param4 else 0)
			sel_198: (if (and (> argc 2) param3) param3 else {})
			sel_200: param1 param2 0 12 param1
			sel_110:
		)
		(StrLen param1)
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
	
	(method (sel_110 theSel_143)
		(= sel_143 0)
		(if argc (= sel_143 theSel_143))
		(if (> argc 1) (self sel_198: &rest))
		(if (not sel_203)
			(if (not (IsObject global92))
				(= global92 ((EventHandler sel_109:) sel_20: {prints}))
			)
			(global92 sel_118: self)
		)
		(self sel_113:)
	)
	
	(method (sel_57)
		(sel_201 sel_119: 57)
	)
	
	(method (sel_111)
		(if (and global92 (global92 sel_122: self))
			(global92 sel_81: self)
			(if (global92 sel_123:)
				(global92 sel_111:)
				(= global92 0)
			)
		)
		(= sel_77 (= sel_124 (= sel_204 (= sel_32 0))))
		(= sel_30 gSel_30)
		(= sel_67 (= sel_27 0))
		(= sel_1 (= sel_0 -1))
		(= sel_203 0)
		(gSounds sel_168: 0)
		(super sel_111:)
	)
	
	(method (sel_113 &tmp theSel_124 temp1 temp2 temp3 temp4)
		(if sel_204 (gGame sel_197: 999))
		(if (not sel_201) (= sel_201 (Dialog sel_109:)))
		(sel_201
			sel_32: (if sel_32 else gLb2Win)
			sel_20: {PODialog}
			sel_143: self
		)
		(sel_201 sel_23: sel_77 sel_22: sel_139 sel_180:)
		(sel_201 sel_192:)
		(= temp3
			(if (== sel_1 -1) (sel_201 sel_7?) else sel_1)
		)
		(= temp4
			(if (== sel_0 -1) (sel_201 sel_6?) else sel_0)
		)
		(sel_201 sel_182: temp3 temp4)
		(= temp1 (GetPort))
		(sel_201 sel_189: (if sel_77 4 else 0) 15)
		(return
			(if sel_203
				(= global41 (GetPort))
				(SetPort temp1)
				(= gSel_201 sel_201)
			else
				(gSounds sel_168: 1)
				(cond 
					((not (= theSel_124 sel_124))
						(if
							(and
								(= theSel_124 (sel_201 sel_120: 185 1))
								(not (sel_201 sel_120: 185 2))
							)
							(theSel_124 sel_29: (| (theSel_124 sel_29?) $0002))
						)
					)
					((not (IsObject theSel_124)) (= theSel_124 (sel_201 sel_64: theSel_124)))
				)
				(= sel_202 (sel_201 sel_57: theSel_124))
				(SetPort temp1)
				(cond 
					((== sel_202 -1) (= sel_202 0))
					(
					(and (IsObject sel_202) (sel_202 sel_114: DButton)) (= sel_202 (sel_202 sel_74?)))
					((not (sel_201 sel_187?)) (= sel_202 1))
				)
				(if sel_204
					(gGame sel_197: ((gIconBar sel_207?) sel_33?))
				)
				(sel_201 sel_111:)
				(return sel_202)
			)
		)
	)
	
	(method (sel_205 param1 theTheGSel_40 &tmp theTheTheGSel_40 theTheTheGSel_40_2 theTheTheGSel_40_3 temp3 theTheTheGSel_40_4 theTheTheGSel_40_5 theGSel_40 temp7 temp8)
		(if (not sel_201) (= sel_201 (Dialog sel_109:)))
		(if (> argc 4)
			(= theTheTheGSel_40 [theTheGSel_40 0])
			(= theTheTheGSel_40_2 [theTheGSel_40 1])
			(= theTheTheGSel_40_3 [theTheGSel_40 2])
			(= temp3 (if [theTheGSel_40 3] [theTheGSel_40 3] else 1))
			(= theTheTheGSel_40_4 0)
			(= theTheTheGSel_40_5 0)
			(= theGSel_40 gSel_40)
			(if (> argc 5)
				(= theTheTheGSel_40_4 [theTheGSel_40 4])
				(if (> argc 6)
					(= theTheTheGSel_40_5 [theTheGSel_40 5])
					(if (> argc 7) (= theGSel_40 [theTheGSel_40 6]))
				)
			)
			(if
				(= temp8
					(Message
						msgSIZE
						theGSel_40
						theTheTheGSel_40
						theTheTheGSel_40_2
						theTheTheGSel_40_3
						temp3
					)
				)
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if
					(not
						(Message
							msgGET
							theGSel_40
							theTheTheGSel_40
							theTheTheGSel_40_2
							theTheTheGSel_40_3
							temp3
							temp7
						)
					)
					(= temp7 0)
				)
			)
		else
			(= theTheTheGSel_40_4 0)
			(= theTheTheGSel_40_5 0)
			(if (> argc 2)
				(= theTheTheGSel_40_4 [theTheGSel_40 1])
				(if (> argc 3) (= theTheTheGSel_40_5 [theTheGSel_40 2]))
			)
			(= temp7
				(Memory memALLOC_CRIT (+ (StrLen [theTheGSel_40 0]) 1))
			)
			(StrCpy temp7 [theTheGSel_40 0])
		)
		(if temp7
			(sel_201
				sel_118:
					((DButton sel_109:)
						sel_74: param1
						sel_30: sel_30
						sel_23: temp7
						sel_180:
						sel_182: (+ 4 theTheTheGSel_40_4) (+ 4 theTheTheGSel_40_5)
						sel_117:
					)
				sel_180:
			)
		)
	)
	
	(method (sel_200 param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not sel_201) (= sel_201 (Dialog sel_109:)))
		(StrCpy param1 (if (> argc 4) param5 else {}))
		(if (> argc 2)
			(= temp0 param3)
			(if (> argc 3) (= temp1 param4))
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
		(if (not sel_201) (= sel_201 (Dialog sel_109:)))
		(if (> argc 3)
			(= temp0 param4)
			(= temp1 param5)
		else
			(= temp0 (= temp1 0))
		)
		(if (IsObject param1)
			(sel_201
				sel_118: (param1
					sel_180:
					sel_182: (+ temp0 4) (+ temp1 4)
					sel_117:
				)
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
	
	(method (sel_198 theTheGSel_40 &tmp theTheTheGSel_40 theTheTheGSel_40_2 theTheTheGSel_40_3 temp3 theTheTheGSel_40_4 theTheTheGSel_40_5 theGSel_40 temp7 temp8)
		(if (not sel_201) (= sel_201 (Dialog sel_109:)))
		(if (> argc 3)
			(= theTheTheGSel_40 [theTheGSel_40 0])
			(= theTheTheGSel_40_2 [theTheGSel_40 1])
			(= theTheTheGSel_40_3 [theTheGSel_40 2])
			(= temp3 (if [theTheGSel_40 3] [theTheGSel_40 3] else 1))
			(= theTheTheGSel_40_4 0)
			(= theTheTheGSel_40_5 0)
			(= theGSel_40 gSel_40)
			(if (>= argc 5)
				(= theTheTheGSel_40_4 [theTheGSel_40 4])
				(if (>= argc 6)
					(= theTheTheGSel_40_5 [theTheGSel_40 5])
					(if (>= argc 7) (= theGSel_40 [theTheGSel_40 6]))
				)
			)
			(if
				(= temp8
					(Message
						msgSIZE
						theGSel_40
						theTheTheGSel_40
						theTheTheGSel_40_2
						theTheTheGSel_40_3
						temp3
					)
				)
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if
					(Message
						msgGET
						theGSel_40
						theTheTheGSel_40
						theTheTheGSel_40_2
						theTheTheGSel_40_3
						temp3
						temp7
					)
					(sel_201
						sel_118:
							((DText sel_109:)
								sel_23: temp7
								sel_30: sel_30
								sel_27: sel_27
								sel_180: sel_67
								sel_182: (+ 4 theTheTheGSel_40_4) (+ 4 theTheTheGSel_40_5)
								sel_117:
							)
						sel_180:
					)
				)
			)
		else
			(= theTheTheGSel_40_4 0)
			(= theTheTheGSel_40_5 0)
			(if (>= argc 2)
				(= theTheTheGSel_40_4 [theTheGSel_40 1])
				(if (>= argc 3)
					(= theTheTheGSel_40_5 [theTheGSel_40 2])
				)
			)
			(= temp7
				(Memory memALLOC_CRIT (+ (StrLen [theTheGSel_40 0]) 1))
			)
			(StrCpy temp7 [theTheGSel_40 0])
			(sel_201
				sel_118:
					((DText sel_109:)
						sel_23: temp7
						sel_30: sel_30
						sel_27: sel_27
						sel_180: sel_67
						sel_182: (+ 4 theTheTheGSel_40_4) (+ 4 theTheTheGSel_40_5)
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
	
	(method (sel_153 theSel_1 theSel_0)
		(= sel_1 theSel_1)
		(= sel_0 theSel_0)
	)
	
	(method (sel_133 param1)
		(if (sel_201 sel_133: param1) (sel_201 sel_111:))
	)
	
	(method (sel_145 &tmp theSel_143)
		(= theSel_143 sel_143)
		(= sel_201 0)
		(if sel_32 (sel_32 sel_111:))
		(self sel_111:)
		(if theSel_143 (theSel_143 sel_145:))
	)
)
