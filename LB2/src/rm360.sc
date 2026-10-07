;;; Sierra Script 1.0 - (do not remove this comment)
(script# 360)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use RotundaRgn)
(use Scaler)
(use CueObj)
(use StopWalk)
(use View)
(use Obj)

(public
	rm360 0
)

(instance rm360 of LBRoom
	(properties
		sel_20 {rm360}
		sel_213 1
		sel_408 360
		sel_28 11
		sel_410 350
	)
	
	(method (sel_110 &tmp [temp0 5])
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 95 0 190 0)
		(if (== global123 2)
			(self sel_414: 93)
			((ScriptID 2360 0) sel_57: (= sel_259 (List sel_109:)))
		else
			(self sel_414: 90)
		)
		(switch gGSel_40
			(sel_410
				(if (> (gEgo sel_0?) 185) (gEgo sel_0: 185))
			)
			(340 (= sel_28 9))
			(else  (gEgo sel_153: 160 140))
		)
		(super sel_110:)
		(gGame sel_588:)
		(eastExitFeature sel_110:)
		(tables sel_110:)
		(column1 sel_110:)
		(column2 sel_110:)
		(column3 sel_110:)
		(column4 sel_110:)
		(column5 sel_110:)
		(alcove sel_110:)
		(bench sel_110:)
		(if (== global123 2)
			(partyATP1 sel_110: sel_320: 170 sel_317:)
			(partyATP2 sel_110: sel_320: 170 sel_317:)
			(partyATP3 sel_110: sel_320: 170 sel_317:)
			(partyATP4 sel_110: sel_320: 170 sel_317:)
			(partyATP5 sel_110: sel_320: 170 sel_317:)
			(partyATP6 sel_110: sel_320: 170 sel_317:)
			(switch global128
				(0
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
					((ScriptID 93 9)
						sel_155: 8
						sel_156: 5
						sel_153: 180 180
						sel_317:
					)
				)
				(1
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 4
						sel_153: 157 180
						sel_317:
					)
					((ScriptID 93 5)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
					((ScriptID 93 9)
						sel_155: 8
						sel_156: 5
						sel_153: 185 180
						sel_317:
					)
					((ScriptID 93 11)
						sel_155: 8
						sel_156: 2
						sel_153: 170 180
						sel_317:
					)
				)
				(2
					((ScriptID 93 11)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 0
						sel_153: 158 185
						sel_317:
					)
					((ScriptID 93 5)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 5
						sel_153: 180 182
						sel_317:
					)
				)
				(3
					((ScriptID 93 5)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 2
						sel_153: 165 182
						sel_317:
					)
					((ScriptID 93 9)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 5
						sel_320: 170
						sel_153: 180 182
						sel_317:
					)
				)
				(4
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 6)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
					((ScriptID 93 9)
						sel_155: 8
						sel_156: 5
						sel_153: 180 180
						sel_317:
					)
				)
				(5
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 6)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
					((ScriptID 93 9)
						sel_155: 8
						sel_156: 5
						sel_153: 180 180
						sel_317:
					)
				)
				(6
					((ScriptID 93 1)
						sel_155: 8
						sel_156: 1
						sel_153: 180 182
						sel_317:
					)
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 6)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
				)
				(7
					((ScriptID 93 1)
						sel_155: 8
						sel_156: 1
						sel_153: 180 182
						sel_317:
					)
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 6)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
				)
				(8
					((ScriptID 93 1)
						sel_155: 8
						sel_156: 1
						sel_153: 180 182
						sel_317:
					)
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 6)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
				)
				(9
					((ScriptID 93 1)
						sel_155: 8
						sel_156: 1
						sel_153: 180 182
						sel_317:
					)
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 6)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
						sel_317:
					)
				)
				(10
					((ScriptID 93 11)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 0
						sel_153: 155 182
						sel_317:
					)
					((ScriptID 93 4)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 5
						sel_320: 170
						sel_153: 166 179
						sel_317:
					)
					((ScriptID 93 1)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 5
						sel_153: 180 182
						sel_317:
					)
				)
				(11
					((ScriptID 93 6)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 4
						sel_153: 155 182
						sel_317:
					)
					((ScriptID 93 11)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 2
						sel_153: 170 185
						sel_317:
					)
				)
				(12
					((ScriptID 93 6)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 4
						sel_153: 150 185
						sel_317:
					)
					((ScriptID 93 9)
						sel_161: StopWalk -1
						sel_155: 8
						sel_156: 5
						sel_320: 170
						sel_153: 165 182
						sel_317:
					)
				)
				(13
					((ScriptID 93 1)
						sel_155: 8
						sel_156: 1
						sel_153: 180 182
						sel_317:
					)
					((ScriptID 93 4)
						sel_155: 8
						sel_156: 2
						sel_153: 160 180
						sel_317:
					)
					((ScriptID 93 9)
						sel_155: 8
						sel_156: 0
						sel_153: 145 182
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
		(DisposeScript 2360)
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(gLb2Messager
				sel_295: sel_213 param1 (if (> global123 2) 2 else 1)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		sel_20 {eastExitFeature}
		sel_6 94
		sel_7 315
		sel_8 189
		sel_9 320
		sel_33 14
		sel_583 2
		sel_213 8
	)
)

(instance tables of Feature
	(properties
		sel_20 {tables}
		sel_0 147
		sel_213 7
		sel_301 40
		sel_302 4096
	)
)

(instance column1 of Feature
	(properties
		sel_20 {column1}
		sel_1 5
		sel_0 93
		sel_213 2
		sel_6 32
		sel_8 155
		sel_9 11
		sel_301 40
	)
)

(instance column2 of Feature
	(properties
		sel_20 {column2}
		sel_1 86
		sel_0 78
		sel_213 2
		sel_6 43
		sel_7 80
		sel_8 113
		sel_9 92
		sel_301 40
	)
)

(instance column3 of Feature
	(properties
		sel_20 {column3}
		sel_1 149
		sel_0 72
		sel_213 2
		sel_6 47
		sel_7 145
		sel_8 97
		sel_9 154
		sel_301 40
	)
)

(instance column4 of Feature
	(properties
		sel_20 {column4}
		sel_1 218
		sel_0 68
		sel_213 2
		sel_6 49
		sel_7 214
		sel_8 88
		sel_9 223
		sel_301 40
	)
)

(instance column5 of Feature
	(properties
		sel_20 {column5}
		sel_1 283
		sel_0 68
		sel_213 2
		sel_6 49
		sel_7 278
		sel_8 87
		sel_9 288
		sel_301 40
	)
)

(instance alcove of Feature
	(properties
		sel_20 {alcove}
		sel_1 119
		sel_0 78
		sel_213 3
		sel_6 45
		sel_7 94
		sel_8 111
		sel_9 145
		sel_301 40
	)
)

(instance bench of Feature
	(properties
		sel_20 {bench}
		sel_1 115
		sel_0 111
		sel_213 4
		sel_6 111
		sel_7 100
		sel_8 117
		sel_9 130
		sel_301 40
	)
)

(instance partyATP1 of View
	(properties
		sel_20 {partyATP1}
		sel_1 216
		sel_0 113
		sel_213 5
		sel_2 374
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
		(super sel_110:)
	)
)

(instance partyATP2 of View
	(properties
		sel_20 {partyATP2}
		sel_1 231
		sel_0 115
		sel_213 5
		sel_2 374
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
		sel_1 119
		sel_0 133
		sel_213 5
		sel_2 374
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
		sel_1 138
		sel_0 126
		sel_213 5
		sel_2 374
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
		sel_1 84
		sel_0 169
		sel_213 5
		sel_2 374
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
		sel_1 101
		sel_0 177
		sel_213 5
		sel_2 374
		sel_4 15
	)
)
