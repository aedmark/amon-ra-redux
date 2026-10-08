;;; Sierra Script 1.0 - (do not remove this comment)
(script# 350)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use RotundaRgn)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm350 0
	proc350_2 2
	proc350_23 23
)

(local
	local0
)
(procedure (proc350_2)
)

(procedure (proc350_23)
)

(instance rm350 of LBRoom
	(properties
		sel_20 {rm350}
		sel_213 5
		sel_408 350
		sel_409 420
		sel_410 370
		sel_411 335
		sel_412 360
	)
	
	(method (sel_110 &tmp [temp0 5])
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 95 75 190 120)
		(if (== global123 5) (proc958_0 128 424))
		(if (> global123 2)
			(self sel_414: 90)
		else
			(self sel_414: 93)
			((ScriptID 2350 0) sel_57: (= sel_259 (List sel_109:)))
		)
		(switch gGSel_40
			(sel_409
				(if (== global123 5)
					(gEgo
						sel_1: 275
						sel_0: 100
						sel_352: 6
						sel_338: 2 1
						sel_253: 180
					)
					(self sel_146: sLauraDies)
				else
					(gEgo sel_153: 270 100 sel_349: 0 sel_253: 180)
				)
			)
			(sel_411
				(self sel_146: sEnterSouth)
			)
			(330
				(self sel_146: sEnterSouth 0 1)
			)
			(sel_410 (= sel_28 11))
			(sel_412 (= sel_28 12))
			(340 (= sel_28 9))
			(else 
				(gEgo sel_153: 70 175)
				(= global123 2)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (not sel_142) (gGame sel_588:))
		(southExitFeature sel_110:)
		(eastExitFeature sel_110:)
		(westExitFeature sel_110:)
		(tables sel_110:)
		(waterGlass1 sel_110: sel_311: 4)
		(waterGlass2 sel_110: sel_311: 4)
		(waterGlass3 sel_110: sel_311: 4)
		(tutHead sel_110:)
		(plants sel_110:)
		(arch sel_110:)
		(column1 sel_110:)
		(column2 sel_110:)
		(if (== global123 2)
			(partyATP1 sel_110: sel_320: 170 sel_317:)
			(partyATP2 sel_110: sel_320: 170 sel_317:)
			(partyATP3 sel_110: sel_320: 170 sel_317:)
			(partyATP4 sel_110: sel_320: 170 sel_317:)
		)
		(cond 
			((not (== global123 2)))
			(
				(and
					(proc0_2 122)
					(proc0_10 29188)
					(not (proc0_10 8))
					(> (gEgo sel_0?) 175)
					(not (proc999_5 global128 0 1 4 5 9 13))
				)
				(self sel_146: sMeetSteve)
			)
			(else
				(switch global128
					(0
						((ScriptID 93 6)
							sel_155: 8
							sel_156: 4
							sel_153: 158 179
							sel_317:
						)
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 5
							sel_153: 180 179
							sel_317:
						)
						((ScriptID 93 10)
							sel_155: 8
							sel_156: 1
							sel_153: 192 180
							sel_317:
						)
						((ScriptID 93 11)
							sel_155: 8
							sel_156: 2
							sel_153: 166 180
							sel_317:
						)
						((ScriptID 93 12)
							sel_155: 8
							sel_156: 0
							sel_153: 149 182
							sel_317:
						)
					)
					(1
						((ScriptID 93 6)
							sel_155: 8
							sel_156: 4
							sel_153: 158 180
							sel_317:
						)
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 5
							sel_153: 180 179
							sel_317:
						)
						((ScriptID 93 10)
							sel_155: 8
							sel_156: 1
							sel_153: 192 185
							sel_317:
						)
						((ScriptID 93 12)
							sel_155: 8
							sel_156: 0
							sel_153: 149 182
							sel_317:
						)
					)
					(2
						((ScriptID 93 1)
							sel_155: 8
							sel_156: 3
							sel_153: 140 182
							sel_317:
						)
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 1
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 12)
							sel_155: 8
							sel_156: 0
							sel_153: 165 182
							sel_317:
						)
					)
					(3
						((ScriptID 93 1)
							sel_155: 8
							sel_156: 3
							sel_153: 140 182
							sel_317:
						)
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 5
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 12)
							sel_155: 8
							sel_156: 0
							sel_153: 165 182
							sel_317:
						)
					)
					(4
						((ScriptID 93 1)
							sel_155: 8
							sel_156: 5
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 2
							sel_153: 165 182
							sel_317:
						)
					)
					(5
						((ScriptID 93 1)
							sel_155: 8
							sel_156: 5
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 12)
							sel_155: 8
							sel_156: 0
							sel_153: 160 182
							sel_317:
						)
					)
					(6
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 5
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 9)
							sel_155: 8
							sel_156: 4
							sel_153: 165 182
							sel_317:
						)
					)
					(7
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 5
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 9)
							sel_155: 8
							sel_156: 4
							sel_153: 165 182
							sel_317:
						)
					)
					(8
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 1
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 9)
							sel_155: 8
							sel_156: 4
							sel_153: 150 182
							sel_317:
						)
						((ScriptID 93 11)
							sel_155: 8
							sel_156: 2
							sel_153: 165 180
							sel_317:
						)
					)
					(9
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 2
							sel_153: 165 179
							sel_317:
						)
						((ScriptID 93 9)
							sel_155: 8
							sel_156: 5
							sel_153: 180 180
							sel_320: 170
							sel_317:
						)
						((ScriptID 93 11)
							sel_155: 8
							sel_156: 0
							sel_153: 155 182
							sel_317:
						)
					)
					(10
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 5
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 9)
							sel_155: 8
							sel_156: 4
							sel_153: 165 182
							sel_317:
						)
					)
					(11
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 5
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 9)
							sel_155: 8
							sel_156: 4
							sel_153: 165 182
							sel_317:
						)
					)
					(12
						((ScriptID 93 7)
							sel_155: 8
							sel_156: 1
							sel_153: 180 182
							sel_317:
						)
						((ScriptID 93 11)
							sel_155: 8
							sel_156: 0
							sel_153: 160 182
							sel_317:
						)
					)
					(13
						((ScriptID 93 8)
							sel_155: 8
							sel_156: 4
							sel_153: 160 181
							sel_317:
						)
						((ScriptID 93 11)
							sel_155: 8
							sel_156: 2
							sel_153: 175 183
							sel_317:
						)
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
			((proc0_1 gEgo 2) (self sel_146: sExitNorth))
			((and (proc0_1 gEgo 4) (not (== global123 2))) (self sel_146: sCantLeave))
		)
	)
	
	(method (sel_111)
		(super sel_111:)
		(DisposeScript 2350)
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(gLb2Messager
				sel_295: sel_213 param1 (if (> global123 2) 5 else 4)
			)
		else
			(super sel_300: param1)
		)
	)
	
	(method (sel_399 param1)
		(if (== param1 sel_411)
			(DrawPic 780 dpOPEN_FADEPALETTE)
		)
		(super sel_399: param1)
	)
)

(instance sEnterSouth of Script
	(properties
		sel_20 {sEnterSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(proc0_3 25)
				(if (== (gSel_608 sel_40?) 335)
					(gSel_608 sel_170: 127 5 5 0)
				else
					(gSel_608 sel_40: 335 sel_99: 1 sel_155: -1 sel_39:)
				)
				(gEgo
					sel_349: 0
					sel_153: 100 225
					sel_312: PolyPath 100 180 self
				)
				(if sel_141
					((ScriptID 93 8)
						sel_110:
						sel_153: 110 230
						sel_161: StopWalk -1
						sel_312: PolyPath 110 180 self
					)
				else
					(= sel_136 1)
				)
			)
			(1 0)
			(2
				(if sel_141
					(gEgo sel_352: (= global3 global149))
					((ScriptID 93 8)
						sel_15: 0
						sel_312: PolyPath 330 180 self
					)
				else
					(= sel_136 1)
				)
			)
			(3
				(if sel_141 ((ScriptID 93 8) sel_111:))
				(gGame sel_588:)
				(gEgo sel_585: 831)
				(self sel_111:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties
		sel_20 {sExitNorth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: MoveTo 265 (- (gEgo sel_0?) 15) self)
			)
			(1
				(global2 sel_399: (global2 sel_409?))
			)
		)
	)
)

(instance sCantLeave of Script
	(properties
		sel_20 {sCantLeave}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: MoveTo (gEgo sel_1?) 180 self)
			)
			(1
				(if (not (proc0_3 70)) (gLb2Messager sel_295: 12 1 2))
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sMeetSteve of Script
	(properties
		sel_20 {sMeetSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(if (< (gEgo sel_1?) 160)
					((ScriptID 93 8)
						sel_161: StopWalk -1
						sel_153: 240 180
						sel_3: 1
						sel_110:
						sel_312: PolyPath 185 180
					)
					(gEgo sel_312: PolyPath 140 180 self)
				else
					((ScriptID 93 8)
						sel_161: StopWalk -1
						sel_153: 80 180
						sel_3: 0
						sel_110:
						sel_312: PolyPath 140 180
					)
					(gEgo sel_312: PolyPath 185 180 self)
				)
			)
			(1
				(proc0_5 gEgo (ScriptID 93 8))
				(proc0_5 (ScriptID 93 8) gEgo)
				(= sel_136 2)
			)
			(2
				(gLb2Messager sel_295: 15 0 0 0 self)
			)
			(3
				(gEgo sel_338: 3 2 sel_312: PolyPath (gEgo sel_1?) 240 self)
			)
			(4
				((ScriptID 93 8)
					sel_312: PolyPath ((ScriptID 93 8) sel_1?) 250 self
				)
			)
			(5
				((ScriptID 22 0) sel_57: 8)
				(global2 sel_399: 335)
			)
		)
	)
)

(instance sGetWaterGlass of Script
	(properties
		sel_20 {sGetWaterGlass}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo
					sel_2: 855
					sel_156: 0
					sel_155: (if (== sel_141 waterGlass3) 0 else 1)
					sel_244: 12
					sel_161: CT 5 1 self
				)
			)
			(1
				(gEgo
					sel_350: 28
					sel_585: 831
					sel_3: (if (== sel_141 waterGlass3) 6 else 7)
				)
				((ScriptID 21 0) sel_57: 797)
				(self sel_111:)
			)
		)
	)
)

(instance sLauraDies of Script
	(properties
		sel_20 {sLauraDies}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 1))
			(1
				(gEgo sel_312: MoveFwd 80)
				(oriley
					sel_110:
					sel_153: 270 85
					sel_320: 165
					sel_253: 180
					sel_161: StopWalk -1
					sel_312: MoveFwd 20 self
				)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
			)
			(2
				(oriley
					sel_2: 424
					sel_155: 0
					sel_156: 0
					sel_161: End self
				)
			)
			(3
				(thudSound sel_39:)
				(gEgo sel_312: 0 sel_2: 858 sel_155: 4 sel_161: End self)
			)
			(4 (= sel_139 60))
			(5
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_2 423
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 6
		sel_8 189
		sel_9 314
		sel_33 11
		sel_583 3
		sel_213 12
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
		sel_213 14
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
		sel_213 13
	)
)

(instance tables of Feature
	(properties
		sel_20 {tables}
		sel_0 152
		sel_213 1
		sel_301 40
		sel_302 4096
	)
)

(instance waterGlass1 of Feature
	(properties
		sel_20 {waterGlass1}
		sel_1 42
		sel_0 153
		sel_213 8
		sel_6 132
		sel_7 30
		sel_8 142
		sel_9 54
		sel_301 40
		sel_303 61
		sel_304 168
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (gEgo sel_238: 28)
					(gLb2Messager sel_295: sel_213 param1 3)
				else
					(global2 sel_146: sGetWaterGlass 0 self)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance waterGlass2 of Feature
	(properties
		sel_20 {waterGlass2}
		sel_1 211
		sel_0 153
		sel_213 8
		sel_6 147
		sel_7 206
		sel_8 157
		sel_9 217
		sel_301 40
		sel_303 227
		sel_304 174
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (gEgo sel_238: 28)
					(gLb2Messager sel_295: sel_213 param1 3)
				else
					(global2 sel_146: sGetWaterGlass 0 self)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance waterGlass3 of Feature
	(properties
		sel_20 {waterGlass3}
		sel_1 110
		sel_0 153
		sel_213 8
		sel_6 141
		sel_7 104
		sel_8 152
		sel_9 116
		sel_301 40
		sel_303 90
		sel_304 170
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (gEgo sel_238: 28)
					(gLb2Messager sel_295: sel_213 param1 3)
				else
					(global2 sel_146: sGetWaterGlass 0 self)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance tutHead of Feature
	(properties
		sel_20 {tutHead}
		sel_1 160
		sel_0 100
		sel_213 2
		sel_301 40
		sel_302 16384
	)
)

(instance plants of Feature
	(properties
		sel_20 {plants}
		sel_1 100
		sel_0 100
		sel_213 3
		sel_302 8192
	)
)

(instance arch of Feature
	(properties
		sel_20 {arch}
		sel_1 268
		sel_0 72
		sel_213 6
		sel_6 56
		sel_7 255
		sel_8 89
		sel_9 281
		sel_301 40
	)
)

(instance column1 of Feature
	(properties
		sel_20 {column1}
		sel_1 27
		sel_0 68
		sel_213 4
		sel_6 50
		sel_7 24
		sel_8 87
		sel_9 31
		sel_301 40
	)
)

(instance column2 of Feature
	(properties
		sel_20 {column2}
		sel_1 289
		sel_0 71
		sel_213 4
		sel_6 53
		sel_7 286
		sel_8 89
		sel_9 293
		sel_301 40
	)
)

(instance partyATP1 of View
	(properties
		sel_20 {partyATP1}
		sel_1 287
		sel_0 151
		sel_213 7
		sel_2 374
		sel_4 15
		sel_14 16384
	)
	
	(method (sel_110)
		(super sel_110:)
		(self sel_317:)
	)
)

(instance partyATP2 of View
	(properties
		sel_20 {partyATP2}
		sel_1 271
		sel_0 145
		sel_213 7
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
		(self sel_317:)
	)
)

(instance partyATP3 of View
	(properties
		sel_20 {partyATP3}
		sel_1 50
		sel_0 130
		sel_213 7
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
		(self sel_317:)
	)
)

(instance partyATP4 of View
	(properties
		sel_20 {partyATP4}
		sel_1 28
		sel_0 131
		sel_213 7
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
		(super sel_110:)
		(self sel_317:)
	)
)

(instance thudSound of Sound
	(properties
		sel_20 {thudSound}
		sel_99 5
		sel_40 80
	)
)
