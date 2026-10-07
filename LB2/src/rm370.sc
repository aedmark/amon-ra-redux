;;; Sierra Script 1.0 - (do not remove this comment)
(script# 370)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use RotundaRgn)
(use Scaler)
(use CueObj)
(use MoveFwd)
(use View)
(use Obj)

(public
	rm370 0
)

(instance rm370 of LBRoom
	(properties
		sel_20 {rm370}
		sel_213 5
		sel_408 370
		sel_28 12
		sel_410 400
		sel_412 350
	)
	
	(method (sel_110 &tmp [temp0 6])
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 95 75 190 120)
		(if (== global123 2)
			(self sel_414: 93)
			((ScriptID 2370 0) sel_57: (= sel_259 (List sel_109:)))
		else
			(self sel_414: 90)
			(if (== gGSel_40 355)
				((ScriptID 90 5) sel_182: 420 sel_618: 500)
				((ScriptID 90 1) sel_182: 420 sel_618: 510)
				((ScriptID 90 7) sel_182: 450 sel_664:)
				((ScriptID 90 4) sel_182: 454 sel_664:)
				((ScriptID 90 2) sel_182: -2)
				((ScriptID 32 0) sel_182: -2)
				((ScriptID 90 6)
					sel_182: 550
					sel_153: 175 130
					sel_253: 1
				)
				((ScriptID 90 3)
					sel_648: 818
					sel_182: 430
					sel_153: 155 165
					sel_253: 135
				)
			)
		)
		(switch gGSel_40
			(sel_410
				(= sel_28 100)
				(gEgo sel_349: 0 sel_253: 270)
			)
			(340 (= sel_28 9))
			(355 0)
			(sel_412
				(if (> (gEgo sel_0?) 185) (gEgo sel_0: 185))
			)
			(else  (gEgo sel_153: 160 160))
		)
		(super sel_110:)
		(if (!= gGSel_40 sel_410) (gGame sel_588:))
		(westExitFeature sel_110:)
		(giftShoppeDoor sel_110:)
		(if (> global123 2) (giftShoppeDoor sel_590: 1))
		(tables sel_110:)
		(column1 sel_110:)
		(column2 sel_110:)
		(column3 sel_110:)
		(column4 sel_110:)
		(column5 sel_110:)
		(bench sel_110:)
		(alcove sel_110:)
		(doorway sel_110: sel_311: 4)
		(if (== global123 2)
			(partyATP1 sel_320: 170 sel_317:)
			(partyATP2 sel_320: 170 sel_317:)
			(partyATP3 sel_320: 170 sel_317:)
			(partyATP4 sel_320: 170 sel_317:)
			(partyATP5 sel_320: 170 sel_317:)
			(partyATP6 sel_320: 170 sel_317:)
			(switch global128
				(0
					((ScriptID 93 1)
						sel_155: 8
						sel_156: 3
						sel_153: 160 180
						sel_317:
					)
				)
				(1
					((ScriptID 93 1)
						sel_155: 8
						sel_156: 3
						sel_153: 160 180
						sel_317:
					)
				)
				(2
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 3
						sel_153: 160 180
						sel_317:
					)
				)
				(3
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 6
						sel_153: 155 180
						sel_317:
					)
					((ScriptID 93 11)
						sel_155: 8
						sel_156: 7
						sel_153: 170 180
						sel_317:
					)
				)
				(4
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 140 180
						sel_317:
					)
					((ScriptID 93 11)
						sel_155: 8
						sel_156: 2
						sel_153: 155 180
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 1
						sel_153: 170 180
						sel_317:
					)
				)
				(5
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 140 180
						sel_317:
					)
					((ScriptID 93 11)
						sel_155: 8
						sel_156: 2
						sel_153: 155 180
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 1
						sel_153: 170 180
						sel_317:
					)
				)
				(6
					((ScriptID 93 12)
						sel_155: 8
						sel_156: 0
						sel_153: 155 185
						sel_317:
					)
					((ScriptID 93 11)
						sel_155: 8
						sel_156: 2
						sel_153: 165 186
						sel_317:
					)
				)
				(7
					((ScriptID 93 11)
						sel_155: 8
						sel_156: 0
						sel_153: 150 185
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 5
						sel_153: 165 183
						sel_317:
					)
				)
				(8
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 2
						sel_153: 155 182
						sel_317:
					)
					((ScriptID 93 12)
						sel_155: 8
						sel_156: 0
						sel_153: 165 185
						sel_317:
					)
				)
				(9
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 140 180
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 3
						sel_153: 155 183
						sel_317:
					)
					((ScriptID 93 12)
						sel_155: 8
						sel_156: 7
						sel_153: 170 180
						sel_317:
					)
				)
				(10
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 140 180
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 3
						sel_153: 155 183
						sel_317:
					)
					((ScriptID 93 12)
						sel_155: 8
						sel_156: 7
						sel_153: 170 180
						sel_317:
					)
				)
				(11
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 140 180
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 3
						sel_153: 155 183
						sel_317:
					)
					((ScriptID 93 12)
						sel_155: 8
						sel_156: 7
						sel_153: 170 180
						sel_317:
					)
				)
				(12
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 140 180
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 3
						sel_153: 155 183
						sel_317:
					)
					((ScriptID 93 12)
						sel_155: 8
						sel_156: 7
						sel_153: 170 180
						sel_317:
					)
				)
				(13
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 140 180
						sel_317:
					)
					((ScriptID 93 10)
						sel_155: 8
						sel_156: 3
						sel_153: 155 183
						sel_317:
					)
					((ScriptID 93 12)
						sel_155: 8
						sel_156: 7
						sel_153: 170 180
						sel_317:
					)
				)
			)
		)
		(if
			(and
				(== gGSel_40 340)
				(== gSel_40 (RotundaRgn sel_667?))
			)
			(while (proc0_1 gEgo 8)
				(gEgo
					sel_1: (- (gEgo sel_1?) 1)
					sel_0: (- (gEgo sel_0?) 1)
				)
			)
		)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((not (gUser sel_237:)))
			(
				(and
					(== global123 2)
					(proc0_1 gEgo 8)
					(== gSel_40 (RotundaRgn sel_667?))
				)
				(RotundaRgn sel_403:)
			)
		)
	)
	
	(method (sel_111)
		(super sel_111:)
		(DisposeScript 2370)
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(gLb2Messager
				sel_295: sel_213 param1 (if (> global123 2) 1 else 2)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance sExitEast of Script
	(properties
		sel_20 {sExitEast}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_63: 9 sel_312: MoveFwd 30 self)
			)
			(1
				(gEgo sel_349: 2)
				(global2 sel_399: (global2 sel_410?))
			)
		)
	)
)

(instance giftShoppeDoor of Door
	(properties
		sel_20 {giftShoppeDoor}
		sel_1 276
		sel_0 145
		sel_213 9
		sel_303 257
		sel_304 149
		sel_2 371
		sel_589 400
		sel_597 300
		sel_598 145
		sel_599 0
		sel_600 0
	)
	
	(method (sel_606)
		(super sel_606: 255 140 271 140 288 152 273 152)
	)
)

(instance westExitFeature of ExitFeature
	(properties
		sel_20 {westExitFeature}
		sel_6 94
		sel_8 189
		sel_9 5
		sel_33 12
		sel_583 4
		sel_213 4
	)
)

(instance tables of Feature
	(properties
		sel_20 {tables}
		sel_0 147
		sel_213 8
		sel_301 40
		sel_302 4096
	)
)

(instance column1 of Feature
	(properties
		sel_20 {column1}
		sel_1 35
		sel_0 72
		sel_213 1
		sel_6 54
		sel_7 30
		sel_8 91
		sel_9 40
		sel_301 40
	)
)

(instance column2 of Feature
	(properties
		sel_20 {column2}
		sel_1 100
		sel_0 73
		sel_213 1
		sel_6 55
		sel_7 95
		sel_8 92
		sel_9 105
		sel_301 40
	)
)

(instance column3 of Feature
	(properties
		sel_20 {column3}
		sel_1 168
		sel_0 77
		sel_213 1
		sel_6 52
		sel_7 163
		sel_8 102
		sel_9 173
		sel_301 40
	)
)

(instance column4 of Feature
	(properties
		sel_20 {column4}
		sel_1 231
		sel_0 83
		sel_213 1
		sel_6 47
		sel_7 226
		sel_8 119
		sel_9 237
		sel_301 40
	)
)

(instance column5 of Feature
	(properties
		sel_20 {column5}
		sel_1 312
		sel_0 100
		sel_213 1
		sel_6 39
		sel_7 305
		sel_8 162
		sel_9 319
		sel_301 40
	)
)

(instance bench of Feature
	(properties
		sel_20 {bench}
		sel_1 200
		sel_0 116
		sel_213 2
		sel_6 108
		sel_7 186
		sel_8 120
		sel_9 214
		sel_301 40
	)
)

(instance alcove of Feature
	(properties
		sel_20 {alcove}
		sel_1 198
		sel_0 87
		sel_213 3
		sel_6 51
		sel_7 174
		sel_8 118
		sel_9 223
		sel_301 40
	)
)

(instance doorway of Feature
	(properties
		sel_20 {doorway}
		sel_1 261
		sel_0 101
		sel_213 9
		sel_6 54
		sel_7 244
		sel_8 139
		sel_9 278
		sel_301 40
	)
	
	(method (sel_300)
		(giftShoppeDoor sel_300: &rest)
	)
)

(instance partyATP1 of View
	(properties
		sel_20 {partyATP1}
		sel_1 104
		sel_0 103
		sel_213 6
		sel_2 374
		sel_14 16384
	)
	
	(method (sel_110)
		(= sel_4
			(switch (Random 0 4)
				(0 2)
				(1 7)
				(2 24)
				(3 26)
				(4 29)
			)
		)
		(= sel_3 (/ sel_4 16))
		(= sel_4 (mod sel_4 16))
		(= sel_103 1)
		(= sel_105 (= sel_104 75))
		(super sel_110:)
	)
)

(instance partyATP2 of View
	(properties
		sel_20 {partyATP2}
		sel_1 119
		sel_0 105
		sel_213 6
		sel_2 374
		sel_14 16384
	)
	
	(method (sel_110)
		(= sel_4
			(switch (Random 0 5)
				(0 3)
				(1 4)
				(2 19)
				(3 25)
				(4 27)
				(5 31)
			)
		)
		(= sel_3 (/ sel_4 16))
		(= sel_4 (mod sel_4 16))
		(super sel_110:)
	)
)

(instance partyATP3 of View
	(properties
		sel_20 {partyATP3}
		sel_1 171
		sel_0 133
		sel_213 6
		sel_2 374
		sel_14 16384
	)
	
	(method (sel_110)
		(= sel_4
			(switch (Random 0 1)
				(0 5)
				(1 28)
			))
		(= sel_3 (/ sel_4 16))
		(= sel_4 (mod sel_4 16))
		(super sel_110:)
	)
)

(instance partyATP4 of View
	(properties
		sel_20 {partyATP4}
		sel_1 190
		sel_0 126
		sel_213 6
		sel_2 374
		sel_14 16384
	)
	
	(method (sel_110)
		(= sel_4
			(switch (Random 0 5)
				(0 0)
				(1 1)
				(2 12)
				(3 16)
				(4 21)
				(5 23)
			)
		)
		(= sel_3 (/ sel_4 16))
		(= sel_4 (mod sel_4 16))
		(super sel_110:)
	)
)

(instance partyATP5 of View
	(properties
		sel_20 {partyATP5}
		sel_1 226
		sel_0 169
		sel_213 6
		sel_2 374
		sel_14 16384
	)
	
	(method (sel_110)
		(= sel_4
			(switch (Random 0 8)
				(0 6)
				(1 9)
				(2 10)
				(3 11)
				(4 13)
				(5 17)
				(6 18)
				(7 20)
				(8 30)
			)
		)
		(= sel_3 (/ sel_4 16))
		(= sel_4 (mod sel_4 16))
		(super sel_110:)
	)
)

(instance partyATP6 of View
	(properties
		sel_20 {partyATP6}
		sel_1 243
		sel_0 177
		sel_213 6
		sel_2 374
		sel_4 15
		sel_14 16384
	)
)
