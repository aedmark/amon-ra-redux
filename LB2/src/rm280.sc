;;; Sierra Script 1.0 - (do not remove this comment)
(script# 280)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use RTRandCycle)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm280 0
	carSound 1
	drunk 2
	Drunk 41
)

(instance rm280 of LBRoom
	(properties
		sel_20 {rm280}
		sel_213 6
		sel_408 280
		sel_409 290
		sel_411 210
		sel_107 155
	)
	
	(method (sel_110)
		(proc958_0 128 285 284 852 281 830 283)
		(proc958_0 132 40 97 281 280 252)
		(self sel_414: 91)
		(gEgo sel_110: sel_585: 830 sel_320: Scaler 90 20 190 0)
		(switch gGSel_40
			(sel_409
				(gEgo sel_349: 0 sel_253: 180)
			)
			(sel_411
				(global2 sel_146: sUpCurb)
			)
			(else 
				(global2 sel_146: sOutCab)
			)
		)
		(super sel_110:)
		(gSel_608 sel_40: 280 sel_99: 1 sel_3: 1 sel_39:)
		(global2
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						121
						129
						101
						129
						123
						151
						124
						160
						94
						163
						94
						179
						55
						182
						49
						187
						206
						187
						195
						189
						0
						189
						0
						0
						319
						0
						319
						189
						311
						139
						256
						144
						288
						152
						226
						161
						209
						151
						182
						154
						168
						127
						140
						127
						140
						116
						148
						116
						148
						120
						162
						120
						162
						106
						121
						106
					sel_117:
				)
				((Polygon sel_109:)
					sel_31: 2
					sel_110: 246 164 277 162 275 167 249 170
					sel_117:
				)
		)
		(if (proc0_2 8)
			(if
				(not
					(if (or (gEgo sel_238: 0) (gEgo sel_238: 3))
					else
						(proc0_2 7)
					)
				)
				(newsPaper sel_110: sel_311: 1 4 8)
			)
		else
			(drunk sel_110: sel_311: 1 2 6 sel_146: sSnore)
		)
		(column sel_110:)
		(leftLion sel_110:)
		(rightLion sel_110:)
		(sidewalk sel_110:)
		(steps sel_110:)
		(street sel_110:)
		(policeSign sel_110:)
		(windows sel_110:)
		(southExitFeature sel_110:)
		(frontDoor sel_110:)
		(stuckDoor sel_110: sel_311: 4)
		(taxiSign sel_110:)
		(taxi sel_110: sel_320: 200)
	)
	
	(method (sel_111)
		(carSound sel_111:)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sPutUpInset of Script
	(properties
		sel_20 {sPutUpInset}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1
				(gLb2Messager sel_295: (if sel_141 3 else 14) 1 0 0 self)
			)
			(2 (self sel_111:))
		)
	)
)

(instance sUpCurb of Script
	(properties
		sel_20 {sUpCurb}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 164 170 self)
			)
			(1
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sOutCab of Script
	(properties
		sel_20 {sOutCab}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_1: 209 sel_0: 172)
				(taxi sel_110: sel_1: 238 sel_0: 189 sel_155: 5)
				(= sel_136 1)
			)
			(1
				(gGameMusic2 sel_173: 2 224 2000 sel_170:)
				(taxi sel_312: MoveTo 0 280 self)
			)
			(2
				(gGame sel_588:)
				(taxi sel_153: 411 171)
				(taxi sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sDrunkWakes of Script
	(properties
		sel_20 {sDrunkWakes}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(proc0_3 8)
				(gEgo sel_312: PolyPath 56 182 self)
			)
			(1 (proc0_5 gEgo drunk self))
			(2
				(gNarrator sel_1: 15 sel_0: 15)
				(gLb2Messager sel_295: 2 4 1 1)
				(gEgo sel_2: 283 sel_3: 1 sel_4: 0 sel_161: End self)
			)
			(3
				(drunk sel_146: 0 sel_244: 10 sel_161: End self)
			)
			(4
				(gLb2Messager sel_295: 2 4 1 2)
				(gEgo sel_161: Beg self)
			)
			(5
				(gEgo sel_2: 830 sel_161: StopWalk -1)
				(gNarrator sel_1: -1 sel_0: -1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetNewsPaper of Script
	(properties
		sel_20 {sGetNewsPaper}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_2: 281 sel_3: 0 sel_4: 0 sel_161: CT 2 1 self)
				(newsPaper sel_111:)
			)
			(1 (gEgo sel_161: End self))
			(2
				(gGame sel_588:)
				(gEgo sel_350: 0)
				((ScriptID 21 0) sel_57: 769)
				(gEgo
					sel_2: 830
					sel_3: 1
					sel_4: 1
					sel_161: StopWalk -1
					sel_312: MoveTo (+ (gEgo sel_1?) 5) (gEgo sel_0?) self
				)
			)
			(3 (self sel_111:))
		)
	)
)

(instance sSnore of Script
	(properties
		sel_20 {sSnore}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_139 30))
			(1
				(drunk sel_161: CT 2 1)
				(carSound sel_40: 281 sel_99: 5 sel_3: 1 sel_39: self)
			)
			(2 (= sel_139 30))
			(3
				(drunk sel_161: CT 0 -1 self)
			)
			(4 (self sel_110:))
		)
	)
)

(instance sHailCab of Script
	(properties
		sel_20 {sHailCab}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gGameMusic2 sel_40: 252 sel_99: 1 sel_3: -1 sel_39: 20)
				(gEgo
					sel_312:
						PolyPath
						(- (taxiSign sel_1?) 20)
						(+ (taxiSign sel_0?) 2)
						self
				)
			)
			(1
				(gEgo
					sel_2: 852
					sel_3: 0
					sel_153: (- (gEgo sel_1?) 2) (gEgo sel_0?)
					sel_161: End self
				)
				(gSel_608 sel_40: 97 sel_99: 1 sel_3: 1 sel_39:)
			)
			(2
				(gGameMusic2 sel_173: 2 224 2000 sel_170: 127 5 5 0)
				(taxi sel_110: sel_155: 5 sel_312: MoveTo 238 189 self)
			)
			(3
				(gGameMusic2 sel_173: 2 224 1600)
				(= sel_136 1)
			)
			(4
				(gGameMusic2 sel_173: 2 224 1200)
				(= sel_136 1)
			)
			(5
				(gGameMusic2 sel_173: 2 224 800)
				(= sel_136 1)
			)
			(6
				(gGameMusic2 sel_173: 2 224 400)
				(= sel_136 1)
			)
			(7
				(gGameMusic2 sel_173: 2 224 0)
				(carSound sel_40: 40 sel_3: 1 sel_99: 5 sel_39:)
				(gEgo sel_102:)
				(= sel_139 30)
			)
			(8 (global2 sel_399: 250))
		)
	)
)

(instance frontDoor of Door
	(properties
		sel_20 {frontDoor}
		sel_1 120
		sel_0 72
		sel_213 1
		sel_303 131
		sel_304 131
		sel_2 281
		sel_3 2
		sel_589 290
		sel_597 152
		sel_598 119
		sel_599 0
		sel_600 0
	)
	
	(method (sel_606)
		(super sel_606: 116 121 145 118 146 125 117 128)
	)
)

(instance drunk of Prop
	(properties
		sel_20 {drunk}
		sel_1 20
		sel_0 184
		sel_213 2
		sel_303 56
		sel_304 182
		sel_2 283
		sel_14 16384
		sel_244 30
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (not (proc0_2 8))
					(global2 sel_146: sDrunkWakes)
				else
					(gLb2Messager sel_295: 2 4 2)
				)
			)
			(6
				(gLb2Messager sel_295: 2 6 4)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance taxi of Actor
	(properties
		sel_20 {taxi}
		sel_1 411
		sel_0 171
		sel_2 852
		sel_3 5
		sel_244 4
		sel_53 0
	)
)

(instance newsPaper of View
	(properties
		sel_20 {newsPaper}
		sel_1 37
		sel_0 187
		sel_213 11
		sel_303 54
		sel_304 186
		sel_2 281
		sel_3 1
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_422: paperInset)
			)
			(1
				(global2 sel_422: paperInset)
			)
			(8
				(global2 sel_422: paperInset)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance taxiSign of View
	(properties
		sel_20 {taxiSign}
		sel_1 257
		sel_0 165
		sel_213 4
		sel_301 40
		sel_2 284
		sel_3 1
		sel_4 1
		sel_60 12
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (global2 sel_146: sHailCab))
			(else  (super sel_300: param1))
		)
	)
)

(instance stuckDoor of Feature
	(properties
		sel_20 {stuckDoor}
		sel_1 155
		sel_0 98
		sel_213 1
		sel_6 73
		sel_7 144
		sel_8 123
		sel_9 167
		sel_301 40
		sel_303 131
		sel_304 131
	)
	
	(method (sel_300 param1)
		(frontDoor sel_300: param1)
	)
)

(instance column of Feature
	(properties
		sel_20 {column}
		sel_0 3
		sel_213 15
		sel_302 8
	)
)

(instance leftLion of Feature
	(properties
		sel_20 {leftLion}
		sel_0 3
		sel_213 9
		sel_302 64
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(gLb2Messager sel_295: 9 6 4)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance rightLion of Feature
	(properties
		sel_20 {rightLion}
		sel_0 3
		sel_213 16
		sel_302 128
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(gLb2Messager sel_295: 16 6 4)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance sidewalk of Feature
	(properties
		sel_20 {sidewalk}
		sel_0 3
		sel_213 12
		sel_302 2
	)
)

(instance steps of Feature
	(properties
		sel_20 {steps}
		sel_0 3
		sel_213 10
		sel_302 16384
	)
)

(instance street of Feature
	(properties
		sel_20 {street}
		sel_0 3
		sel_213 8
		sel_302 4
	)
)

(instance policeSign of Feature
	(properties
		sel_20 {policeSign}
		sel_0 3
		sel_213 17
		sel_6 20
		sel_7 115
		sel_8 32
		sel_9 186
	)
)

(instance windows of Feature
	(properties
		sel_20 {windows}
		sel_0 3
		sel_213 13
		sel_302 32
	)
)

(instance paperInset of Inset
	(properties
		sel_20 {paperInset}
		sel_2 285
		sel_3 1
		sel_1 7
		sel_0 110
		sel_570 1
		sel_213 11
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(self sel_146: sPutUpInset 0 0)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(self sel_111:)
				(global2 sel_422: inCoupon)
			)
			(8
				(self sel_111:)
				(global2 sel_422: inCoupon)
			)
			(1
				(self sel_111:)
				(global2 sel_422: inCoupon)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inCoupon of Inset
	(properties
		sel_20 {inCoupon}
		sel_2 285
		sel_1 7
		sel_0 110
		sel_570 1
		sel_213 3
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(self sel_146: sPutUpInset 0 1)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(self sel_111:)
				(global2 sel_146: sGetNewsPaper)
			)
			(8 (gLb2Messager sel_295: 3 1))
			(1 (gLb2Messager sel_295: 3 1))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 183
		sel_8 189
		sel_9 320
		sel_33 11
		sel_583 3
		sel_213 7
	)
)

(instance carSound of Sound
	(properties
		sel_20 {carSound}
		sel_99 5
		sel_40 40
	)
)

(instance Drunk of Narrator
	(properties
		sel_20 {Drunk}
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(= sel_540 1)
		(super sel_110: &rest)
	)
)
