;;; Sierra Script 1.0 - (do not remove this comment)
(script# 18)
(include sci.sh)
(use Main)
(use LBRoom)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm18 0
)

(local
	sel_42Sel_4
	local1
	local2
	local3 =  25
	[local4 25] = [0 1 1 2 3 4 5 5 5 6 6 6 7 7 7 7 8 8 8 9 9 10 10 10 11]
	local29 =  1
)
(instance tempList of List
	(properties
		sel_20 {tempList}
	)
)

(instance goodList of List
	(properties
		sel_20 {goodList}
	)
)

(instance rm18 of LBRoom
	(properties
		sel_20 {rm18}
		sel_408 18
	)
	
	(method (sel_110 &tmp temp0 temp1 temp2 temp3)
		(asm
			pushi    2
			pushi    128
			pushi    18
			calle    proc958_0,  4
			pushi    #sel_110
			pushi    0
			super    LBRoom,  4
			pushi    #sel_588
			pushi    0
			lag      gGame
			send     4
			pushi    #sel_233
			pushi    7
			pushi    0
			pushi    1
			pushi    3
			pushi    4
			pushi    5
			pushi    6
			pushi    7
			lag      gIconBar
			send     18
			pushi    #sel_118
			pushi    0
			lofsa    goodList
			send     4
			pushi    #sel_118
			pushi    0
			lofsa    tempList
			send     4
			ldi      65504
			sat      temp2
			ldi      46
			sat      temp3
			ldi      0
			sat      temp0
code_0087:
			lst      temp0
			ldi      12
			lt?     
			bnt      code_00ad
			pushi    #sel_118
			pushi    1
			pushi    #sel_4
			pushi    1
			lst      temp0
			pushi    117
			pushi    0
			pushi    #sel_109
			pushi    0
			lofsa    egyptProp
			send     4
			send     10
			push    
			lofsa    tempList
			send     6
			+at      temp0
			jmp      code_0087
code_00ad:
			pushi    #sel_86
			pushi    0
			lofsa    tempList
			send     4
			bnt      code_0116
			pushi    2
			pushi    0
			pushi    #sel_86
			pushi    0
			lofsa    tempList
			send     4
			push    
			ldi      1
			sub     
			push    
			callk    Random,  4
			sat      temp0
			pushi    #sel_64
			pushi    1
			push    
			lofsa    tempList
			send     6
			sat      temp1
			pushi    118
			pushi    #sel_1
			pushi    1
			pushi    #sel_1
			lst      temp2
			ldi      48
			add     
			sat      temp2
			push    
			pushi    0
			pushi    1
			lst      temp3
			pushi    117
			pushi    0
			lat      temp1
			send     16
			push    
			lofsa    goodList
			send     6
			pushi    #sel_86
			pushi    0
			lofsa    goodList
			send     4
			push    
			ldi      6
			eq?     
			bnt      code_010a
			ldi      65504
			sat      temp2
			ldi      111
			sat      temp3
code_010a:
			pushi    #sel_81
			pushi    1
			lst      temp1
			lofsa    tempList
			send     6
			jmp      code_00ad
code_0116:
			pushi    #sel_587
			pushi    0
			lag      gGame
			send     4
			pushi    #sel_146
			pushi    1
			lofsa    sInitEm
			push    
			self     6
			ret     
		)
	)
	
	(method (sel_111)
		(goodList sel_125: sel_111:)
		(tempList sel_125: sel_111:)
		(super sel_111:)
	)
	
	(method (sel_133)
		(return 0)
	)
)

(instance sInitEm of Script
	(properties
		sel_20 {sInitEm}
	)
	
	(method (sel_144 theSel_29 &tmp temp0)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 2))
			(1
				((goodList sel_120: 96 checkCel sel_141)
					sel_110:
					sel_146: sFlipIt self sel_141
				)
			)
			(2
				(if (< (++ sel_141) (goodList sel_86?))
					(= sel_29 0)
					(= sel_136 1)
				else
					(= sel_65 sAskIt)
					(self sel_111:)
				)
			)
		)
	)
)

(instance sFlipIt of Script
	(properties
		sel_20 {sFlipIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= sel_42Sel_4 (sel_42 sel_4?))
				(sel_42 sel_3: 1 sel_4: 0)
				(sel_42 sel_161: End self)
			)
			(1
				(gGameMusic2 sel_40: 55 sel_99: 1 sel_3: 1 sel_39:)
				(sel_42 sel_3: 0 sel_4: sel_42Sel_4 sel_317:)
				(if (== sel_141 11) (gGame sel_588: 1))
				(self sel_111:)
			)
		)
	)
)

(instance sAskIt of Script
	(properties
		sel_20 {sAskIt}
	)
	
	(method (sel_144 theSel_29 &tmp [temp0 50])
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 1))
			(1
				(if
					(or
						(== (= local1 (Random 1 local3)) global146)
						(== local1 global147)
					)
					(-- sel_29)
					(self sel_145:)
				else
					(switch global123
						(1
							(= global146 local1)
							(= local2 230)
						)
						(3
							(= global147 local1)
							(= local2 355)
						)
						(5 (= local2 420))
					)
				)
				(= sel_137 2)
			)
			(2
				(Message msgGET 18 2 0 0 local1 @temp0)
				(Display
					@temp0
					100
					15
					15
					105
					61
					106
					280
					101
					1
					102
					global151
				)
				(Display @temp0 100 15 15 105 60 106 280 101 1 102 23)
			)
			(3
				(if local29 (proc0_3 34) else (proc0_4 34))
				(global2 sel_399: local2)
			)
		)
	)
)

(instance egyptProp of Prop
	(properties
		sel_20 {egyptProp}
		sel_2 18
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(== sel_4 [local4 (- local1 1)])
				(sAskIt sel_145:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance checkCel of Code
	(properties
		sel_20 {checkCel}
	)
	
	(method (sel_57 param1 param2)
		(return (== (param1 sel_4?) param2))
	)
)
