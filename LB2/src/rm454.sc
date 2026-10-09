;;; Sierra Script 1.0 - (do not remove this comment)
(script# 454)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use PChase)
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
	rm454 0
)

(local
	local0 =  100
	local1
	local2
)
(instance rm454 of LBRoom
	(properties
		sel_20 {rm454}
		sel_213 11
		sel_408 454
		sel_28 11
		sel_410 450
		sel_108 20
	)
	
	(method (sel_110)
		(proc958_0 128 423 451 858 424 454)
		(proc958_0 132 1 451 452 453 450)
		(proc958_0 130 2450)
		(switch gGSel_40
			(666
				(gGame sel_587:)
				(gGameMusic2 sel_40: 450 sel_99: 1 sel_3: -1 sel_39:)
				(Palette palSET_INTENSITY 0 255 100)
				(= sel_28 100)
				(gEgo
					sel_585: 831
					sel_1: 211
					sel_0: 120
					sel_3: 2
					sel_320: Scaler 131 30 190 21
					sel_110:
				)
				(lid1 sel_110: sel_313: sel_311: 1 4 2 6 sel_63: 7)
				(global2 sel_146: sEnterTunnel)
			)
			(455
				(gGame sel_587:)
				(= sel_28 100)
				(gEgo
					sel_316:
					sel_1: 248
					sel_0: 121
					sel_2: 454
					sel_3: 2
					sel_4: (gEgo sel_246:)
					sel_110:
				)
				(global2 sel_146: sFinishIt)
			)
			(456
				(= sel_28 100)
				(gGame sel_588:)
				(gEgo
					sel_110:
					sel_153: 96 135
					sel_320: Scaler 131 30 190 21
					sel_585: 831
				)
				(lid1 sel_110: sel_313: sel_311: 1 4 2 6 sel_63: 7)
			)
			(else 
				(gEgo
					sel_110:
					sel_153: 160 160
					sel_320: Scaler 131 30 190 21
					sel_585: (if (== global123 5) 426 else 831)
				)
				(lid1 sel_110: sel_313: sel_311: 1 4 2 6 sel_63: 7)
				(gGame sel_588:)
			)
		)
		(if (== global123 5)
			(cond 
				((< global87 5) (= local2 85))
				((< global87 10) (= local2 60))
				((<= global87 15) (= local2 35))
			)
			(if (not (HaveMouse)) (= local2 (* 2 local2)))
			(self sel_414: 94)
			(global2 sel_259: (List sel_109:))
			((ScriptID 2454 0) sel_57: (global2 sel_259?))
		else
			(self sel_414: 90)
		)
		(super sel_110:)
		(if
			(or
				(and (== global123 2) (proc0_10 -32480 1))
				(> global123 2)
			)
			(blood sel_110: sel_311: 1 4 8 sel_313: sel_4: global127)
			(footprint sel_110: sel_313: sel_311: 1 4 8)
			(if (and (== global123 2) (proc0_10 -32480 1))
				(deadPippin sel_110: sel_313: sel_63: 6)
			)
			(if (not (gEgo sel_238: 20))
				(medallion sel_110: sel_313: sel_311: 1 4 8)
			)
		)
		(lid2
			sel_110:
			sel_313:
			sel_4: (if global115 3 else 2)
			sel_311: 1 4 2 6
			sel_63: 7
		)
		(poster sel_110: sel_311: 1 4)
		(post sel_110: sel_311: 1 4)
		(mummy1 sel_110: sel_311: 1 4 2 6)
		(secretDoor1 sel_110: sel_311: 1 4 2 6)
		(secretDoor2 sel_110: sel_311: 1 4 2 6)
		(mummy3 sel_110: sel_311: 1 4 2 6)
		(rosetta sel_110: sel_311: 1 4 6 2 8)
		(pyramid sel_110:)
		(pyramid2 sel_110:)
		(eastExitFeature sel_110:)
	)
	
	(method (sel_111)
		(DisposeScript 2454)
		(super sel_111: &rest)
	)
	
	(method (sel_399 param1)
		(if
			(and
				(< global127 6)
				(== global123 2)
				(proc0_10 -32480 1)
			)
			(++ global127)
		)
		(super sel_399: param1)
	)
	
	(method (sel_403)
		(if (== global123 5)
			(if (global2 sel_142?)
				((global2 sel_142?) sel_65: sDie)
			else
				(global2 sel_146: sDie)
			)
		)
	)
)

(instance sEnterTunnel of Script
	(properties
		sel_20 {sEnterTunnel}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1
				(secretDoor1
					sel_312: MoveTo (- (secretDoor1 sel_1?) 10) (secretDoor1 sel_0?)
				)
				(secretDoor2
					sel_312: MoveTo (+ (secretDoor2 sel_1?) 8) (secretDoor2 sel_0?) self
				)
			)
			(2
				(gEgo sel_312: MoveFwd 25 self)
			)
			(3
				(secretDoor1
					sel_312: MoveTo (+ (secretDoor1 sel_1?) 10) (secretDoor1 sel_0?)
				)
				(secretDoor2
					sel_312: MoveTo (- (secretDoor2 sel_1?) 8) (secretDoor2 sel_0?) self
				)
			)
			(4
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sDie of Script
	(properties
		sel_20 {sDie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 180 160 self)
			)
			(1
				(oriley
					sel_110:
					sel_320: Scaler 131 30 190 21
					sel_161: Walk
					sel_312: PChase gEgo 22 self
				)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
			)
			(2
				(oriley sel_2: 424)
				(oriley sel_4: 0)
				(proc0_5 gEgo oriley)
				(proc0_5 oriley gEgo)
				(= sel_136 4)
			)
			(3 (oriley sel_161: End self))
			(4
				(thudSound sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(5
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sOpenRedCoffin of Script
	(properties
		sel_20 {sOpenRedCoffin}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(lid1 sel_102:)
				(gEgo
					sel_2: 454
					sel_155: 2
					sel_4: 0
					sel_153: 248 121
					sel_244: 6
					sel_161: End self
				)
				(nCreak sel_40: 452 sel_39:)
			)
			(1
				(gLb2Messager
					sel_295: 6 4 (if (== global123 5) 1 else 2) 0 self
				)
			)
			(2
				(gEgo sel_161: Beg self)
				(nCreak sel_40: 453 sel_39:)
			)
			(3
				(nCreak sel_40: 455 sel_39:)
				(lid1 sel_216:)
				(gEgo sel_585: 831)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sHandleTheCase of Script
	(properties
		sel_20 {sHandleTheCase}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if sel_141 (= global115 1) else (= global115 0))
				(gGame sel_587:)
				(lid2 sel_102:)
				(gEgo
					sel_2: 454
					sel_3: 3
					sel_4: (if sel_141 0 else (gEgo sel_246:))
					sel_153: 184 122
					sel_244: 6
					sel_161: (if sel_141 End else Beg) self
				)
				(nCreak sel_40: (if sel_141 452 else 453) sel_39:)
			)
			(1
				(if (not sel_141) (nCreak sel_40: 455 sel_39:))
				(lid2 sel_4: (if sel_141 3 else 2) sel_313: sel_216:)
				(gEgo sel_585: 831)
				(gEgo sel_253: 0)
				(= sel_137 3)
			)
			(2
				(if (!= global123 5) (gGame sel_588:))
				(self sel_111:)
			)
		)
	)
)

(instance sORileyComes of Script
	(properties
		sel_20 {sORileyComes}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(oriley
					sel_110:
					sel_320: Scaler 131 30 190 21
					sel_161: Walk
					sel_312: PolyPath 300 172 self
				)
			)
			(1 (= sel_137 4))
			(2
				(oriley sel_312: PolyPath 340 172 self)
			)
			(3
				((ScriptID 94 1) sel_162: (ScriptID 94 1) local2)
				(proc0_3 47)
				(self sel_111:)
			)
		)
	)
)

(instance sHide of Script
	(properties
		sel_20 {sHide}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gSel_608 sel_40: 17 sel_99: 1 sel_3: -1 sel_39:)
				(gGame sel_587:)
				(proc0_3 90)
				(if (proc0_2 39) ((ScriptID 94 1) sel_111: sel_81:))
				(if global115
					(= sel_136 1)
				else
					(self sel_146: sHandleTheCase self 1)
				)
			)
			(1
				(gEgo sel_312: MoveTo 178 120 self)
			)
			(2
				(gEgo sel_253: 180)
				(= sel_136 1)
			)
			(3
				(lid2 sel_102:)
				(gEgo
					sel_2: 454
					sel_3: 4
					sel_4: 0
					sel_63: 6
					sel_153: 184 122
					sel_161: End self
				)
				(nCreak sel_40: 453 sel_39:)
			)
			(4
				(nCreak sel_40: 455 sel_39:)
				(if (proc0_2 39)
					(self sel_146: sORileyComes self)
				else
					(= sel_139 120)
				)
			)
			(5
				(gEgo sel_161: Beg self)
				(nCreak sel_40: 452 sel_39:)
			)
			(6
				(lid2 sel_216:)
				(gEgo sel_585: 426)
				(= sel_137 3)
			)
			(7
				(if (proc0_2 39)
					(gLb2Messager sel_295: 16 0 0 0 self)
					(gGameMusic2 sel_40: 444 sel_99: 5 sel_3: 1 sel_39:)
				else
					(= sel_136 1)
				)
				(gEgo sel_216:)
				(gEgo
					sel_312: MoveTo (gEgo sel_1?) (+ (gEgo sel_0?) 10) self
				)
			)
			(8
				(= global115 0)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetAnkh of Script
	(properties
		sel_20 {sGetAnkh}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_2: 451 sel_3: 4 sel_4: 0 sel_161: CT 5 1 self)
			)
			(1
				(medallion sel_111:)
				(gEgo sel_161: End self)
				(gEgo sel_350: 20)
			)
			(2
				(gEgo sel_585: 831)
				((ScriptID 21 0) sel_57: 789)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sFinishIt of Script
	(properties
		sel_20 {sFinishIt}
	)
	
	(method (sel_57)
		(if (and local1 local0)
			(Palette palSET_INTENSITY 0 255 (-- local0))
			(if (not local0) (self sel_145:))
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gSel_608 sel_40: 450 sel_99: 1 sel_3: -1 sel_39:)
				(= sel_136 2)
			)
			(1
				(oriley sel_2: 818 sel_153: 330 160 sel_110:)
				(= sel_136 1)
			)
			(2
				(oriley sel_161: StopWalk -1 sel_312: PChase gEgo 22 self)
			)
			(3 (= sel_136 5))
			(4
				(lid1 sel_110: sel_313: sel_4: 1)
				(gEgo
					sel_585: 831
					sel_320: Scaler 131 30 190 21
					sel_312: PolyPath (gEgo sel_1?) (+ (gEgo sel_0?) 10)
				)
				(proc0_5 gEgo oriley)
				(= sel_136 5)
			)
			(5
				((ScriptID 22 0) sel_57: -32480)
				(= sel_137 10)
			)
			(6
				(gLb2Messager sel_295: 13 0 0 0 self)
			)
			(7
				(= local1 1)
				(gIconBar sel_233: 7)
				(gSel_608 sel_40: 454 sel_99: 1 sel_3: 1 sel_39: self)
			)
			(8 0)
			(9 (global2 sel_399: 26))
		)
	)
)

(instance sUhOh of Script
	(properties
		sel_20 {sUhOh}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(lid1 sel_102:)
				(gEgo
					sel_2: 454
					sel_155: 2
					sel_4: 0
					sel_153: 248 121
					sel_244: 6
					sel_161: 0
				)
				(= sel_136 1)
			)
			(1
				(gGameMusic2 sel_40: 451 sel_99: 1 sel_3: 1 sel_39: self)
			)
			(2
				(gEgo sel_161: End self)
				(nCreak sel_40: 452 sel_39: self)
			)
			(3 0)
			(4
				(lid1 sel_4: 1 sel_313: sel_216:)
				(global2 sel_399: 455)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 340
		sel_0 172
		sel_2 423
	)
)

(instance secretDoor1 of Actor
	(properties
		sel_20 {secretDoor1}
		sel_1 211
		sel_0 121
		sel_213 5
		sel_303 213
		sel_304 130
		sel_2 454
		sel_3 6
		sel_14 18432
	)
)

(instance secretDoor2 of Actor
	(properties
		sel_20 {secretDoor2}
		sel_1 212
		sel_0 121
		sel_213 5
		sel_303 213
		sel_304 130
		sel_2 454
		sel_3 6
		sel_4 1
		sel_14 18432
	)
)

(instance lid1 of Prop
	(properties
		sel_20 {lid1}
		sel_1 248
		sel_0 121
		sel_213 6
		sel_2 454
		sel_3 5
		sel_14 16384
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(4
				(if (and (== global123 2) (proc0_10 -32480 1))
					(global2 sel_146: sUhOh)
				else
					(global2 sel_146: sOpenRedCoffin)
				)
			)
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance lid2 of Prop
	(properties
		sel_20 {lid2}
		sel_1 184
		sel_0 122
		sel_213 4
		sel_2 454
		sel_3 5
		sel_4 2
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					(global115 (global2 sel_146: sHandleTheCase 0 0))
					((and (== global123 5) (not (proc0_2 90))) (global2 sel_146: sHide))
					((== global123 5) (gLb2Messager sel_295: 15 4 1))
					(else (global2 sel_146: sHandleTheCase 0 1))
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance deadPippin of View
	(properties
		sel_20 {deadPippin}
		sel_1 244
		sel_0 118
		sel_2 454
		sel_3 1
		sel_14 16384
	)
)

(instance footprint of View
	(properties
		sel_20 {footprint}
		sel_1 228
		sel_0 128
		sel_303 214
		sel_304 126
		sel_2 451
		sel_3 3
		sel_14 16384
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(8
				(global2 sel_422: inFootPrint)
			)
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance medallion of View
	(properties
		sel_20 {medallion}
		sel_1 227
		sel_0 122
		sel_213 1
		sel_303 214
		sel_304 126
		sel_2 451
		sel_3 3
		sel_4 1
		sel_14 16384
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(8
				(gGame sel_87: 1 136)
				(global2 sel_422: inAnkh)
			)
			(4 (global2 sel_146: sGetAnkh))
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance blood of View
	(properties
		sel_20 {blood}
		sel_1 235
		sel_0 120
		sel_213 2
		sel_303 214
		sel_304 126
		sel_2 451
		sel_60 3
		sel_14 16400
	)
)

(instance poster of Feature
	(properties
		sel_20 {poster}
		sel_1 36
		sel_0 81
		sel_213 8
		sel_6 72
		sel_7 30
		sel_8 90
		sel_9 42
		sel_301 40
		sel_303 60
		sel_304 139
	)
)

(instance post of Feature
	(properties
		sel_20 {post}
		sel_1 135
		sel_0 189
		sel_213 7
		sel_6 15
		sel_7 115
		sel_8 189
		sel_9 155
		sel_301 40
		sel_303 181
		sel_304 169
	)
)

(instance rosetta of Feature
	(properties
		sel_20 {rosetta}
		sel_1 76
		sel_0 73
		sel_213 12
		sel_301 40
		sel_302 4
		sel_303 96
		sel_304 135
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(8
				(if (== global123 5)
					(gLb2Messager sel_295: 17)
				else
					(gGame sel_87: 1 137)
					((ScriptID 21 0) sel_57: 1025)
					(= temp0 1)
					(while (< temp0 14)
						((ScriptID 21 0) sel_57: (+ temp0 1088))
						(++ temp0)
					)
					(global2 sel_399: 456)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance mummy1 of Feature
	(properties
		sel_20 {mummy1}
		sel_1 176
		sel_0 87
		sel_213 4
		sel_301 40
		sel_302 2
		sel_303 181
		sel_304 127
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					((and (== global123 5) (not (proc0_2 90))) (global2 sel_146: sHide))
					((== global123 5) (gLb2Messager sel_295: 15 4 1))
					(else (super sel_300: param1 &rest))
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance mummy3 of Feature
	(properties
		sel_20 {mummy3}
		sel_1 245
		sel_0 89
		sel_213 6
		sel_301 40
		sel_302 16
		sel_303 249
		sel_304 129
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(4
				(if (and (== global123 2) (proc0_10 -32480 1))
					(global2 sel_146: sUhOh)
				else
					(super sel_300: param1 param2 &rest)
				)
			)
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance pyramid of Feature
	(properties
		sel_20 {pyramid}
		sel_1 58
		sel_0 178
		sel_213 9
		sel_302 64
	)
)

(instance pyramid2 of Feature
	(properties
		sel_20 {pyramid2}
		sel_1 58
		sel_0 178
		sel_213 10
		sel_302 16384
	)
)

(instance inAnkh of Inset
	(properties
		sel_20 {inAnkh}
		sel_2 451
		sel_3 2
		sel_1 202
		sel_0 101
		sel_570 1
		sel_213 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(gNarrator sel_1: 10 sel_0: 140)
	)
	
	(method (sel_111)
		(gNarrator sel_1: -1 sel_0: -1)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(self sel_111:)
				(global2 sel_146: sGetAnkh)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inFootPrint of Inset
	(properties
		sel_20 {inFootPrint}
		sel_2 451
		sel_3 1
		sel_1 204
		sel_0 112
		sel_570 1
		sel_213 3
	)
	
	(method (sel_110)
		(gGame sel_87: 1 179)
		(super sel_110: &rest)
		(gNarrator sel_1: 10 sel_0: 140)
	)
	
	(method (sel_111)
		(gNarrator sel_1: -1 sel_0: -1)
		(super sel_111:)
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		sel_20 {eastExitFeature}
		sel_6 118
		sel_7 314
		sel_8 189
		sel_9 319
		sel_33 14
		sel_583 2
		sel_213 14
	)
)

(instance nCreak of Sound
	(properties
		sel_20 {nCreak}
		sel_99 5
	)
)

(instance thudSound of Sound
	(properties
		sel_20 {thudSound}
		sel_99 5
		sel_40 80
	)
)
