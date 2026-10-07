;;; Sierra Script 1.0 - (do not remove this comment)
(script# 270)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm270 0
)

(local
	gNarratorSel_1
	gNarratorSel_0
	gNarratorSel_537
	local3 =  1
	local4 =  1
	local5 =  1
	local6 =  1
	local7 =  1
	local8 =  1
	local9 =  1
	local10 =  1
	local11 =  1
	local12 =  1
	local13 =  1
	local14 =  1
)
(instance rm270 of LBRoom
	(properties
		sel_20 {rm270}
		sel_213 10
		sel_408 270
		sel_411 260
		sel_107 3
		sel_108 39
	)
	
	(method (sel_110)
		(proc958_0 128 272 271)
		(proc958_0 132 270)
		(gEgo sel_110: sel_320: Scaler 125 0 190 29 sel_585: 830)
		(switch gGSel_40
			(sel_411
				(gEgo sel_153: 160 230)
				(global2 sel_146: sEnter)
			)
			(else 
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		((ScriptID 1881 2)
			sel_1: 215
			sel_0: 95
			sel_549: -170
			sel_550: 5
		)
		(gSel_608 sel_40: 270 sel_99: 1 sel_3: -1 sel_39:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						0
						0
						319
						0
						319
						189
						311
						189
						286
						145
						216
						145
						216
						137
						153
						137
						128
						137
						70
						137
						54
						189
						0
						189
						0
						137
					sel_117:
				)
		)
		(lofat sel_110: sel_311: 1 6 2 4 7 8 sel_161: RandCycle)
		(if (not (gEgo sel_238: 32)) (dress sel_110:))
		(dress2 sel_110: sel_317:)
		(dress3 sel_110: sel_317:)
		(dress4 sel_110: sel_317:)
		(dress5 sel_110: sel_317:)
		(dress6 sel_110: sel_317:)
		(southExitFeature sel_110:)
		(dClothes sel_110:)
		(cClothes sel_110:)
		(lamp sel_110:)
		(symbols sel_110:)
		(jar1 sel_110:)
		(jar2 sel_110:)
		(counter1 sel_110:)
		(counter2 sel_110:)
	)
	
	(method (sel_57)
		(cond 
			(sel_142)
			((proc0_1 gEgo 16) (self sel_146: sEgoLeaveSouth))
		)
		(super sel_57: &rest)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
	
	(method (sel_133 param1)
		(return
			(if (& (param1 sel_31?) $0040)
				(sGetDress sel_145:)
				(return 0)
			else
				(super sel_133: param1)
			)
		)
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(3
					(sGetDress sel_145:)
					(return 0)
				)
				(else 
					(super sel_300: param1 &rest)
				)
			)
		)
	)
)

(instance sEgoLeaveSouth of Script
	(properties
		sel_20 {sEgoLeaveSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_55: 180)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveFwd 80 self)
			)
			(2 (global2 sel_399: 260))
		)
	)
)

(instance sEnter of Script
	(properties
		sel_20 {sEnter}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveTo 160 160 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sShowDress of Script
	(properties
		sel_20 {sShowDress}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= gNarratorSel_1 (gNarrator sel_1?))
				(= gNarratorSel_0 (gNarrator sel_0?))
				(= gNarratorSel_537 (gNarrator sel_537?))
				(gNarrator sel_1: 160 sel_0: 100 sel_537: 120)
				(= sel_136 2)
			)
			(1
				(gLb2Messager sel_295: 12 1 0 0 self)
			)
			(2
				(gNarrator
					sel_1: gNarratorSel_1
					sel_0: gNarratorSel_0
					sel_537: gNarratorSel_537
				)
				(gownInset sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetDress of Script
	(properties
		sel_20 {sGetDress}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(lofat sel_161: End self)
			)
			(1
				(gEgo sel_312: PolyPath 142 138 self)
			)
			(2
				(gEgo sel_2: 271 sel_3: 0 sel_161: CT 3 1 self)
			)
			(3
				(lofat sel_3: 1 sel_4: 0 sel_161: CT 3 1 self)
			)
			(4
				(gLb2Messager sel_295: 1 5 0 1 self)
			)
			(5
				(lofat sel_161: End self)
				(gEgo sel_161: End self)
				(smoke sel_110: sel_161: Fwd)
			)
			(6 0)
			(7
				(gLb2Messager sel_295: 1 5 0 2 self)
			)
			(8
				(lofat sel_3: 2 sel_161: End self)
			)
			(9
				(gLb2Messager sel_295: 1 5 0 3 self)
			)
			(10
				(gLb2Messager sel_295: 1 5 0 4 self)
				(dress sel_111:)
			)
			(11
				(lofat sel_3: 3 sel_161: End self)
			)
			(12
				(gLb2Messager sel_295: 1 5 0 5)
				(dress sel_110: sel_153: 136 94)
				(gEgo sel_350: -1 32)
				(gEgo sel_351: 1)
				((ScriptID 21 0) sel_57: 801)
				((ScriptID 21 1) sel_57: 770)
				(lofat sel_3: 4 sel_4: 0 sel_161: End self)
			)
			(13
				(gLb2Messager sel_295: 1 5 0 6 self)
			)
			(14
				(gLb2Messager sel_295: 1 5 0 7 self)
			)
			(15
				(gEgo sel_585: 830 sel_312: MoveTo 138 133 self)
			)
			(16
				(gEgo sel_2: 271 sel_3: 1 sel_4: 0 sel_161: CT 3 1 self)
			)
			(17
				(dress sel_111:)
				(gEgo sel_161: End self)
			)
			(18
				(gEgo sel_585: 830 sel_312: MoveTo 142 138 self)
			)
			(19
				(gGame sel_588:)
				(gLb2WH sel_129: global2)
				(gLb2DH sel_129: global2)
				(southExitFeature sel_111:)
			)
			(20
				(lofat sel_3: 5 sel_4: 0 sel_161: End self)
			)
			(21
				(smoke sel_111:)
				(lofat sel_3: 0 sel_161: RandCycle)
				(gLb2WH sel_81: global2)
				(gLb2DH sel_81: global2)
				(southExitFeature sel_110:)
				(self sel_111:)
			)
		)
	)
)

(instance lofat of Actor
	(properties
		sel_20 {lofat}
		sel_1 113
		sel_0 102
		sel_213 1
		sel_303 142
		sel_304 138
		sel_2 272
		sel_60 8
		sel_14 16
		sel_244 10
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(switch param1
			(5 (global2 sel_146: sGetDress))
			(4
				(if local5
					(gLb2Messager sel_295: 1 4 98)
					(= local5 0)
				else
					(gLb2Messager sel_295: 1 4 2)
				)
			)
			(2
				(cond 
					(local6 (= temp1 16) (= local6 0))
					((or (gEgo sel_238: 32) (gEgo sel_584?)) (= temp1 67))
					(else (= temp1 13))
				)
				(gLb2Messager sel_295: 1 2 temp1)
			)
			(6
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(switch temp0
					(775
						(if local11
							(gLb2Messager sel_295: 1 6 33)
							(= local11 0)
						else
							(gLb2Messager sel_295: 1 6 91)
						)
					)
					(514
						(if local12
							(gLb2Messager sel_295: 1 6 20)
							(= local12 0)
						else
							(gLb2Messager sel_295: 1 6 93)
						)
					)
					(263
						(if local13
							(gLb2Messager sel_295: 1 6 8)
							(= local13 0)
						else
							(gLb2Messager sel_295: 1 6 95)
						)
					)
					(266
						(if local14
							(gLb2Messager sel_295: 1 6 11)
							(= local14 0)
						else
							(gLb2Messager sel_295: 1 6 96)
						)
					)
					(770
						(if local8
							(gLb2Messager sel_295: 1 6 28)
							(= local8 0)
						else
							(gLb2Messager sel_295: 1 6 83)
						)
					)
					(517
						(if local9
							(gLb2Messager sel_295: 1 6 23)
							(= local9 0)
							((ScriptID 21 0) sel_57: 270)
							((ScriptID 21 0) sel_57: 266)
							((ScriptID 21 0) sel_57: 265)
						else
							(gLb2Messager sel_295: 1 6 85)
						)
					)
					(519
						(if local10
							(gLb2Messager sel_295: 1 6 25)
							(= local10 0)
						else
							(gLb2Messager sel_295: 1 6 86)
						)
					)
					(780
						(if local7
							(gLb2Messager sel_295: 1 6 38)
							(= local7 0)
						else
							(gLb2Messager sel_295: 1 6 78)
						)
					)
					(else 
						(if (Message msgGET gSel_40 sel_213 6 temp1 1)
							(gLb2Messager sel_295: sel_213 6 temp1)
						else
							(gLb2Messager sel_295: sel_213 6 1)
						)
					)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		sel_20 {smoke}
		sel_1 103
		sel_0 100
		sel_2 272
		sel_3 7
		sel_14 16384
	)
)

(instance dress2 of View
	(properties
		sel_20 {dress2}
		sel_1 86
		sel_0 94
		sel_2 272
		sel_3 6
		sel_4 1
		sel_14 16384
	)
)

(instance dress3 of View
	(properties
		sel_20 {dress3}
		sel_1 80
		sel_0 94
		sel_2 272
		sel_3 6
		sel_4 2
		sel_14 16384
	)
)

(instance dress4 of View
	(properties
		sel_20 {dress4}
		sel_1 98
		sel_0 94
		sel_2 272
		sel_3 6
		sel_4 3
		sel_14 16384
	)
)

(instance dress5 of View
	(properties
		sel_20 {dress5}
		sel_1 104
		sel_0 94
		sel_2 272
		sel_3 6
		sel_4 4
		sel_14 16384
	)
)

(instance dress6 of View
	(properties
		sel_20 {dress6}
		sel_1 74
		sel_0 94
		sel_2 272
		sel_3 6
		sel_4 5
		sel_14 16384
	)
)

(instance dress of View
	(properties
		sel_20 {dress}
		sel_1 92
		sel_0 94
		sel_213 12
		sel_2 272
		sel_3 6
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(8 (global2 sel_422: gownInset))
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance dClothes of Feature
	(properties
		sel_20 {dClothes}
		sel_1 250
		sel_0 115
		sel_213 3
		sel_6 95
		sel_7 224
		sel_8 136
		sel_9 277
		sel_301 40
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(1
				(if local3
					(gLb2Messager sel_295: 3 1 98)
					(= local3 0)
				else
					(gLb2Messager sel_295: 3 1 2)
				)
			)
			(4
				(if local4
					(gLb2Messager sel_295: 3 4 98)
					(= local4 0)
				else
					(gLb2Messager sel_295: 3 4 2)
				)
			)
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		sel_20 {lamp}
		sel_1 38
		sel_0 75
		sel_213 4
		sel_6 29
		sel_8 122
		sel_9 76
		sel_301 40
	)
)

(instance cClothes of Feature
	(properties
		sel_20 {cClothes}
		sel_1 214
		sel_0 76
		sel_213 5
		sel_6 52
		sel_7 177
		sel_8 100
		sel_9 251
		sel_301 40
	)
)

(instance symbols of Feature
	(properties
		sel_20 {symbols}
		sel_0 2
		sel_213 6
		sel_7 63
		sel_8 106
		sel_9 104
	)
)

(instance jar1 of Feature
	(properties
		sel_20 {jar1}
		sel_0 2
		sel_213 7
		sel_6 38
		sel_7 185
		sel_8 49
		sel_9 201
	)
)

(instance jar2 of Feature
	(properties
		sel_20 {jar2}
		sel_0 2
		sel_213 8
		sel_6 34
		sel_7 229
		sel_8 48
		sel_9 242
	)
)

(instance counter1 of Feature
	(properties
		sel_20 {counter1}
		sel_0 2
		sel_213 9
		sel_6 110
		sel_7 50
		sel_8 133
		sel_9 142
	)
)

(instance counter2 of Feature
	(properties
		sel_20 {counter2}
		sel_0 2
		sel_213 11
		sel_6 111
		sel_7 161
		sel_8 132
		sel_9 227
	)
)

(instance gownInset of Inset
	(properties
		sel_20 {gownInset}
		sel_2 271
		sel_3 2
		sel_1 62
		sel_0 76
		sel_60 15
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(self sel_146: sShowDress)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 90
		sel_8 189
		sel_9 320
		sel_33 11
		sel_583 3
		sel_213 13
	)
)
