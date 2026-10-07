;;; Sierra Script 1.0 - (do not remove this comment)
(script# 260)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
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
	rm260 0
	Stinky 32
	Biff 33
	Tubby 34
)

(local
	local0 =  1
	local1 =  1
	local2 =  1
)
(instance rm260 of LBRoom
	(properties
		sel_20 {rm260}
		sel_213 13
		sel_408 260
		sel_409 270
		sel_411 300
		sel_108 50
	)
	
	(method (sel_110)
		(proc958_0 128 284 260 852 282 830)
		(proc958_0 132 40 97 260 261)
		(self sel_414: 91)
		(gEgo sel_110: sel_585: 830 sel_320: Scaler 98 0 190 50)
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
		(gSel_608 sel_40: 260 sel_99: 1 sel_3: 1 sel_39:)
		(global2
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						319
						0
						319
						189
						311
						189
						311
						166
						151
						171
						142
						159
						122
						159
						122
						165
						143
						165
						147
						171
						90
						171
						83
						145
						61
						143
						78
						172
						63
						172
						63
						178
						9
						178
						9
						189
						0
						189
						0
						0
					sel_117:
				)
				((Polygon sel_109:)
					sel_31: 2
					sel_110: 92 174 127 174 127 179 92 179
					sel_117:
				)
		)
		(if (not (proc0_2 129))
			(kidR
				sel_110:
				sel_311: 6 4 2 8 15
				sel_146: (sKidsPlaying sel_109:)
			)
			(kidL
				sel_110:
				sel_311: 6 4 2 8 15
				sel_146: (sKidsPlaying sel_109:)
			)
			(kid
				sel_110:
				sel_311: 6 4 2 8 15
				sel_146: (sKidsPlaying sel_109:)
			)
		)
		(southExitFeature sel_110:)
		(sky sel_110:)
		(window1 sel_110:)
		(window2 sel_110:)
		(store sel_110:)
		(lofats sel_110:)
		(storeSign sel_110:)
		(lamp1 sel_110:)
		(lamp2 sel_110:)
		(plant1 sel_110:)
		(plant2 sel_110:)
		(street sel_110:)
		(stairs sel_110:)
		(streetLamp sel_110:)
		(frontDoor sel_110:)
		(taxiSign sel_110:)
		(taxi sel_110: sel_320: 220)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 16) (global2 sel_146: sDownStairs))
		)
	)
	
	(method (sel_111)
		(carSound sel_111:)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sDownStairs of Script
	(properties
		sel_20 {sDownStairs}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_137 3)
			)
			(1
				(gEgo sel_312: PolyPath 91 174 self)
			)
			(2
				(gLb2Messager sel_295: 11 0 11 0 self)
			)
			(3
				(gGame sel_588:)
				(self sel_111:)
			)
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
				(gEgo sel_312: PolyPath 161 170 self)
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
				(gEgo sel_1: 127 sel_0: 171)
				(taxi sel_110: sel_153: 115 188 sel_155: 5)
				(= sel_136 1)
			)
			(1
				(gGameMusic2 sel_173: 2 224 2000 sel_170:)
				(taxi sel_312: MoveTo -30 251 self)
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

(instance sKidsPlaying of Script
	(properties
		sel_20 {sKidsPlaying}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sel_42 sel_161: CT (Random 1 5) 1 self)
			)
			(1 (= sel_139 (Random 10 120)))
			(2 (sel_42 sel_161: End self))
			(3 (= sel_139 (Random 10 120)))
			(4
				(sel_42 sel_161: CT (Random 1 5) -1 self)
			)
			(5 (= sel_139 (Random 10 120)))
			(6 (sel_42 sel_161: Beg self))
			(7 (= sel_139 (Random 10 120)))
			(8 (self sel_144: 0))
		)
	)
)

(instance sTradeBaseBall of Script
	(properties
		sel_20 {sTradeBaseBall}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(kid sel_146: 0)
				(kidL sel_4: 0)
				(= sel_136 1)
			)
			(2
				(gEgo sel_2: 282 sel_3: 5 sel_4: 0 sel_161: End self)
			)
			(3
				(gLb2Messager sel_295: 18 7 0 0 self)
				(kidL sel_161: CT 8 1)
			)
			(4
				(kid sel_3: 3 sel_4: 0 sel_161: CT 7 1 self)
			)
			(5
				(kid sel_161: End self)
				(kidL sel_161: CT 0 -1)
			)
			(6
				(kid sel_3: 0)
				(= sel_136 1)
			)
			(7
				(kid sel_146: sKidsPlaying)
				(gGame sel_87: 1 129)
				((ScriptID 22 0) sel_57: 4)
				((ScriptID 21 0) sel_57: 791)
				((ScriptID 21 1) sel_57: 773)
				(gEgo sel_351: 4 sel_350: 22 sel_161: Beg self)
			)
			(8
				(gGameMusic2 sel_40: 261 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo sel_2: 830 sel_161: StopWalk -1)
				(= sel_136 2)
			)
			(9
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sHailTaxi of Script
	(properties
		sel_20 {sHailTaxi}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_312:
						PolyPath
						(- (taxiSign sel_1?) 20)
						(+ (taxiSign sel_0?) 2)
						self
				)
			)
			(1
				(gGameMusic2 sel_40: 252 sel_99: 1 sel_3: -1 sel_39: 20)
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
				(taxi
					sel_110:
					sel_155: 5
					sel_312: MoveTo (+ (gEgo sel_1?) 28) (+ (gEgo sel_0?) 11) self
				)
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
				(gEgo sel_585: 830 sel_316: sel_312: MoveTo 122 185 self)
			)
			(8
				(gGameMusic2 sel_173: 2 224 0)
				(carSound sel_39:)
				(gEgo sel_102:)
				(= sel_136 5)
			)
			(9 (global2 sel_399: 250))
		)
	)
)

(instance frontDoor of Door
	(properties
		sel_20 {frontDoor}
		sel_1 155
		sel_0 112
		sel_213 1
		sel_303 151
		sel_304 172
		sel_2 260
		sel_589 270
		sel_597 126
		sel_598 164
		sel_599 0
		sel_600 0
	)
	
	(method (sel_606)
		(super sel_606: 135 162 162 162 162 169 135 169)
	)
)

(instance kid of Prop
	(properties
		sel_20 {kid}
		sel_1 40
		sel_0 172
		sel_213 18
		sel_303 63
		sel_304 172
		sel_2 282
		sel_14 20480
		sel_244 8
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(6
				(switch (= temp0 (global2 sel_422: (ScriptID 20 0)))
					(1026
						(gLb2Messager sel_295: 18 6 5)
					)
					(1027
						(gLb2Messager sel_295: 18 6 6)
					)
					(1028
						(gLb2Messager sel_295: 18 6 10)
					)
					(519
						(gLb2Messager sel_295: 18 6 4)
					)
					(else 
						(cond 
							((< temp0 512) (gLb2Messager sel_295: 18 6 1))
							((< temp0 768) (gLb2Messager sel_295: 18 6 2))
							((< temp0 1024) (gLb2Messager sel_295: 18 6 3))
						)
					)
				)
			)
			(7
				(global2 sel_146: sTradeBaseBall)
			)
			(4
				(if local0
					(gLb2Messager sel_295: 18 4 7)
					(= local0 0)
				else
					(gLb2Messager sel_295: 18 4 8)
				)
			)
			(2
				(if local1
					(gLb2Messager sel_295: 18 2 7)
					(= local1 0)
				else
					(gLb2Messager sel_295: 18 2 8)
				)
			)
			(1
				(if (proc0_2 129)
					(gLb2Messager sel_295: 18 1 12)
				else
					(super sel_300: param1)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance kidR of Prop
	(properties
		sel_20 {kidR}
		sel_1 42
		sel_0 174
		sel_213 17
		sel_303 63
		sel_304 172
		sel_2 282
		sel_3 1
		sel_14 20480
		sel_244 8
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(6
				(switch (= temp0 (global2 sel_422: (ScriptID 20 0)))
					(1026
						(gLb2Messager sel_295: 17 6 5)
					)
					(1027
						(gLb2Messager sel_295: 17 6 6)
					)
					(1028
						(gLb2Messager sel_295: 17 6 10)
					)
					(519
						(gLb2Messager sel_295: 17 6 4)
					)
					(else 
						(cond 
							((< temp0 512) (gLb2Messager sel_295: 17 6 1))
							((< temp0 768) (gLb2Messager sel_295: 17 6 2))
							((< temp0 1024) (gLb2Messager sel_295: 17 6 3))
						)
					)
				)
			)
			(2
				(cond 
					((proc0_2 129) (gLb2Messager sel_295: 17 2 12))
					(local2 (gLb2Messager sel_295: 17 2 7) (= local2 0))
					(else (gLb2Messager sel_295: 17 2 8))
				)
			)
			(1
				(if (proc0_2 129)
					(gLb2Messager sel_295: 17 1 12)
				else
					(super sel_300: param1)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance kidL of Prop
	(properties
		sel_20 {kidL}
		sel_1 29
		sel_0 173
		sel_213 19
		sel_303 63
		sel_304 172
		sel_2 282
		sel_3 2
		sel_14 20480
		sel_244 8
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(6
				(switch (= temp0 (global2 sel_422: (ScriptID 20 0)))
					(1026
						(gLb2Messager sel_295: 19 6 5)
					)
					(1027
						(gLb2Messager sel_295: 19 6 6)
					)
					(1028
						(gLb2Messager sel_295: 19 6 10)
					)
					(519
						(gLb2Messager sel_295: 19 6 4)
					)
					(else 
						(cond 
							((< temp0 512) (gLb2Messager sel_295: 19 6 1))
							((< temp0 768) (gLb2Messager sel_295: 19 6 2))
							((< temp0 1024) (gLb2Messager sel_295: 19 6 3))
						)
					)
				)
			)
			(2
				(if (proc0_2 129)
					(gLb2Messager sel_295: 19 2 12)
				else
					(super sel_300: param1)
				)
			)
			(1
				(if (proc0_2 129)
					(gLb2Messager sel_295: 19 1 12)
				else
					(super sel_300: param1)
				)
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
		sel_4 1
		sel_244 4
		sel_53 0
	)
)

(instance Biff of Narrator
	(properties
		sel_20 {Biff}
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(= sel_540 1)
		(super sel_110: &rest)
	)
)

(instance Stinky of Narrator
	(properties
		sel_20 {Stinky}
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(= sel_540 1)
		(super sel_110: &rest)
	)
)

(instance Tubby of Narrator
	(properties
		sel_20 {Tubby}
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(= sel_540 1)
		(super sel_110: &rest)
	)
)

(instance taxiSign of View
	(properties
		sel_20 {taxiSign}
		sel_1 109
		sel_0 175
		sel_213 3
		sel_301 40
		sel_2 284
		sel_3 1
		sel_4 1
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (global2 sel_146: sHailTaxi))
			(else  (super sel_300: param1))
		)
	)
)

(instance sky of Feature
	(properties
		sel_20 {sky}
		sel_0 3
		sel_213 16
		sel_302 8
	)
)

(instance window1 of Feature
	(properties
		sel_20 {window1}
		sel_0 3
		sel_213 4
		sel_6 33
		sel_7 28
		sel_8 71
		sel_9 57
	)
)

(instance window2 of Feature
	(properties
		sel_20 {window2}
		sel_0 3
		sel_213 4
		sel_6 43
		sel_7 75
		sel_8 74
		sel_9 98
	)
)

(instance store of Feature
	(properties
		sel_20 {store}
		sel_0 3
		sel_213 5
		sel_6 78
		sel_8 169
		sel_9 64
	)
)

(instance lofats of Feature
	(properties
		sel_20 {lofats}
		sel_0 3
		sel_213 6
		sel_6 92
		sel_7 108
		sel_8 166
		sel_9 206
	)
)

(instance storeSign of Feature
	(properties
		sel_20 {storeSign}
		sel_0 4
		sel_213 7
		sel_6 102
		sel_7 148
		sel_8 111
		sel_9 188
	)
)

(instance lamp1 of Feature
	(properties
		sel_20 {lamp1}
		sel_0 4
		sel_213 8
		sel_6 97
		sel_7 125
		sel_8 118
		sel_9 137
	)
)

(instance lamp2 of Feature
	(properties
		sel_20 {lamp2}
		sel_0 4
		sel_213 8
		sel_6 104
		sel_7 189
		sel_8 118
		sel_9 198
	)
)

(instance plant1 of Feature
	(properties
		sel_20 {plant1}
		sel_0 3
		sel_213 9
		sel_6 64
		sel_7 110
		sel_8 79
		sel_9 135
	)
)

(instance plant2 of Feature
	(properties
		sel_20 {plant2}
		sel_0 3
		sel_213 9
		sel_6 80
		sel_7 163
		sel_8 89
		sel_9 199
	)
)

(instance street of Feature
	(properties
		sel_20 {street}
		sel_0 3
		sel_213 10
		sel_6 168
		sel_8 189
		sel_9 319
	)
)

(instance stairs of Feature
	(properties
		sel_20 {stairs}
		sel_0 3
		sel_213 11
		sel_6 89
		sel_7 66
		sel_8 169
		sel_9 101
	)
)

(instance streetLamp of Feature
	(properties
		sel_20 {streetLamp}
		sel_0 3
		sel_213 12
		sel_302 2
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_8 189
		sel_9 320
		sel_33 11
		sel_583 3
		sel_213 2
	)
)

(instance carSound of Sound
	(properties
		sel_20 {carSound}
		sel_99 5
		sel_40 40
	)
)
