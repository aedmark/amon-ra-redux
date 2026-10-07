;;; Sierra Script 1.0 - (do not remove this comment)
(script# 430)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use PursuitRgn)
(use PChase)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use Timer)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm430 0
)

(instance rm430 of LBRoom
	(properties
		sel_20 {rm430}
		sel_213 22
		sel_408 430
		sel_409 480
		sel_410 420
		sel_412 440
		sel_107 185
		sel_108 20
	)
	
	(method (sel_110)
		(proc958_0 128 430 432 423 431 858 424)
		(proc958_0 132 430)
		(gEgo
			sel_110:
			sel_585: (if (== global123 5) 426 else 831)
			sel_320: 125
		)
		(if (== global123 5)
			(self sel_414: 94)
			(global2 sel_259: (List sel_109:))
			((ScriptID 2430 0) sel_57: (global2 sel_259?))
		else
			(self sel_414: 90)
		)
		(switch gGSel_40
			(435
				((Timer sel_109:) sel_162: self 3)
			)
			(sel_409
				(gEgo sel_153: 113 119 sel_349: 0 sel_253: 180)
				(gGame sel_588:)
			)
			(sel_410
				(self sel_146: sEnterEast)
			)
			(sel_412
				(gEgo sel_1: 51 sel_0: 121)
				(self sel_146: sEnterWest)
			)
			(else 
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if
			(or
				(> global123 3)
				(and (== global123 3) (proc0_10 -20222 1))
			)
			(skewer sel_110: sel_317: sel_311: 1 8)
			(if (not (proc0_2 44)) (wireEnd sel_110:))
		else
			(pterodactyl sel_110: sel_317:)
		)
		(if (proc0_2 45) (doorWire sel_110:))
		(ceiling sel_110:)
		(westDoor sel_110: sel_313: sel_594: westDoor2)
		(eastDoor
			sel_595: (if (proc0_2 99) 0 else 1)
			sel_110:
			sel_313:
			sel_594: eastDoor2
		)
		(westDoor2 sel_110: sel_313: sel_311: 4)
		(eastDoor2
			sel_110:
			sel_4: (if (proc0_2 99) 0 else 9)
			sel_313:
			sel_311: 4
		)
		(triceratops sel_110:)
		(spinosaur sel_110:)
		(eggs sel_110:)
		(babies sel_110:)
		(struth sel_110:)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (global2 sel_146: sExitEast))
			((proc0_1 gEgo 4) (global2 sel_146: sExitWest))
			((proc0_1 gEgo 8) (self sel_399: sel_409))
		)
	)
	
	(method (sel_111)
		(DisposeScript 2430)
		(super sel_111: &rest)
	)
	
	(method (sel_145)
		(if
		(and (== global123 3) (not (proc0_10 -20222)))
			((ScriptID 22 0) sel_57: -20222)
		)
		(cond 
			((proc0_2 63) (global2 sel_146: sGetThatWire) (proc0_4 63))
			((!= (global2 sel_142?) sDie) (gGame sel_588:))
		)
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

(instance sDie of Script
	(properties
		sel_20 {sDie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(eastDoor sel_590: 0)
				(= sel_137 3)
			)
			(1
				(gGame sel_587:)
				(gGame sel_197: global21)
				(gEgo sel_312: PolyPath 160 160)
				(if (== (eastDoor sel_29?) 0)
					(doorWire sel_111:)
					(eastDoor sel_143: self sel_189:)
					(gGameMusic2 sel_40: 444 sel_99: 5 sel_3: 1 sel_39:)
					(splinters sel_110: sel_161: End)
				else
					(= sel_136 1)
				)
			)
			(2
				(if (== (eastDoor sel_29?) 0) (splinters sel_317:))
				(oriley
					sel_110:
					sel_320: 125
					sel_161: Walk
					sel_312: MoveTo 281 134 self
				)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
			)
			(3
				(oriley sel_312: PChase gEgo 22 self)
			)
			(4
				(oriley sel_2: 424)
				(oriley sel_4: 0)
				(proc0_5 gEgo oriley)
				(proc0_5 oriley gEgo)
				(= sel_136 4)
			)
			(5 (oriley sel_161: End self))
			(6
				(thudSound sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(7
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sWireItShut of Script
	(properties
		sel_20 {sWireItShut}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(PursuitRgn sel_669:)
				(eastDoor sel_316: sel_314:)
				(proc0_3 45)
				(= sel_136 1)
			)
			(1
				(gGame sel_587:)
				(if (!= (eastDoor sel_29?) 0)
					(gEgo sel_312: PolyPath 274 131 self)
				else
					(= sel_136 1)
				)
			)
			(2
				(if (!= (eastDoor sel_29?) 0)
					(eastDoor sel_360:)
					(= sel_139 90)
				else
					(= sel_136 1)
				)
			)
			(3
				(gEgo sel_312: MoveTo 283 124 self)
			)
			(4
				(gEgo sel_2: 431 sel_3: 3 sel_4: 0 sel_161: End self)
			)
			(5
				(doorWire sel_110:)
				(gEgo sel_585: 426)
				(gEgo sel_312: MoveTo 283 124 self)
			)
			(6
				(gEgo sel_351: 34)
				(eastDoor sel_590: 1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetThatWire of Script
	(properties
		sel_20 {sGetThatWire}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 43 141 self)
			)
			(1
				(gEgo sel_2: 431 sel_3: 0 sel_4: 0 sel_161: CT 7 1 self)
			)
			(2
				(gEgo sel_161: End self)
				(wireEnd sel_111:)
				(gGameMusic2 sel_40: 430 sel_99: 5 sel_3: 1 sel_39:)
			)
			(3
				(gEgo sel_585: (if (== global123 5) 426 else 831))
				(gEgo sel_312: MoveTo 62 144 self)
			)
			(4
				(proc0_3 44)
				(gEgo sel_350: 34)
				((ScriptID 21 0) sel_57: 803)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties
		sel_20 {sEnterEast}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_349: 0
					sel_153: 291 125
					sel_253: 270
					sel_312: MoveFwd 35 self
				)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties
		sel_20 {sEnterWest}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo
					sel_349: 0
					sel_253: 90
					sel_312: PolyPath 100 133 self
				)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
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
				(gEgo sel_55: 90 sel_312: MoveTo 320 (gEgo sel_0?) self)
			)
			(1
				(gEgo sel_349: 2)
				(global2 sel_399: (global2 sel_410?))
				(self sel_111:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties
		sel_20 {sExitWest}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_55: 270 sel_312: MoveTo 27 (gEgo sel_0?) self)
			)
			(1
				(gEgo sel_349: 4)
				(global2 sel_399: (global2 sel_412?))
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 340
		sel_0 105
		sel_2 423
	)
)

(instance splinters of Prop
	(properties
		sel_20 {splinters}
		sel_1 299
		sel_0 131
		sel_2 432
		sel_3 4
		sel_14 16384
	)
)

(instance westDoor2 of Prop
	(properties
		sel_20 {westDoor2}
		sel_1 74
		sel_0 66
		sel_303 73
		sel_304 125
		sel_2 432
		sel_3 1
		sel_4 4
	)
	
	(method (sel_300 param1)
		(westDoor sel_300: param1)
	)
)

(instance eastDoor2 of Prop
	(properties
		sel_20 {eastDoor2}
		sel_1 312
		sel_0 68
		sel_303 287
		sel_304 128
		sel_2 432
		sel_3 3
		sel_4 9
		sel_60 9
		sel_14 16
	)
	
	(method (sel_300 param1)
		(eastDoor sel_300: param1)
	)
)

(instance doorWire of View
	(properties
		sel_20 {doorWire}
		sel_1 300
		sel_0 96
		sel_2 431
		sel_3 2
		sel_4 1
		sel_60 9
		sel_14 16
	)
)

(instance wireEnd of View
	(properties
		sel_20 {wireEnd}
		sel_1 21
		sel_0 130
		sel_2 431
		sel_3 4
		sel_4 1
		sel_60 15
		sel_14 16400
	)
)

(instance skewer of View
	(properties
		sel_20 {skewer}
		sel_1 3
		sel_0 189
		sel_82 89
		sel_213 7
		sel_303 150
		sel_304 170
		sel_2 430
		sel_3 1
		sel_60 15
		sel_14 20496
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (global2 sel_399: 435))
			(8 (global2 sel_399: 435))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance pterodactyl of View
	(properties
		sel_20 {pterodactyl}
		sel_1 43
		sel_0 189
		sel_82 107
		sel_213 6
		sel_2 430
		sel_60 14
		sel_14 20496
	)
)

(instance ceiling of Feature
	(properties
		sel_20 {ceiling}
		sel_0 6
		sel_213 21
		sel_8 20
		sel_9 320
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager
					sel_295:
						21
						1
						(if
							(or
								(> global123 3)
								(and (== global123 3) (proc0_10 -20222 1))
							)
							2
						else
							1
						)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance triceratops of Feature
	(properties
		sel_20 {triceratops}
		sel_1 202
		sel_0 72
		sel_213 4
		sel_6 39
		sel_7 135
		sel_8 105
		sel_9 270
		sel_301 40
		sel_303 208
		sel_304 116
	)
)

(instance spinosaur of Feature
	(properties
		sel_20 {spinosaur}
		sel_1 19
		sel_0 87
		sel_213 5
		sel_6 61
		sel_7 4
		sel_8 114
		sel_9 34
		sel_301 40
		sel_303 37
		sel_304 151
	)
)

(instance eggs of Feature
	(properties
		sel_20 {eggs}
		sel_1 249
		sel_0 100
		sel_213 1
		sel_301 40
		sel_302 16
		sel_303 254
		sel_304 116
	)
)

(instance babies of Feature
	(properties
		sel_20 {babies}
		sel_1 252
		sel_0 92
		sel_213 3
		sel_301 40
		sel_302 32
		sel_303 255
		sel_304 116
	)
)

(instance struth of Feature
	(properties
		sel_20 {struth}
		sel_1 234
		sel_0 147
		sel_213 2
		sel_301 40
		sel_302 64
		sel_303 153
		sel_304 168
	)
)

(instance eastDoor of Door
	(properties
		sel_20 {eastDoor}
		sel_1 292
		sel_0 68
		sel_213 18
		sel_303 287
		sel_304 128
		sel_2 432
		sel_3 2
		sel_589 420
		sel_596 0
		sel_597 319
		sel_598 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(44
				(if (== global123 5)
					(global2 sel_146: sWireItShut)
				else
					(super sel_300: param1 &rest)
				)
			)
			(4
				(if (== sel_29 0) (proc0_4 99) else (proc0_3 99))
				(super sel_300: param1 &rest)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
	
	(method (sel_145)
		(super sel_145:)
		(eastDoor2 sel_313:)
	)
	
	(method (sel_606)
		(super sel_606: 292 110 319 123 319 133 309 137 280 122)
	)
)

(instance westDoor of Door
	(properties
		sel_20 {westDoor}
		sel_1 53
		sel_0 66
		sel_213 19
		sel_303 73
		sel_304 125
		sel_2 432
		sel_60 9
		sel_14 16
		sel_589 440
		sel_595 1
		sel_596 0
		sel_597 31
		sel_598 127
	)
	
	(method (sel_145)
		(super sel_145:)
		(westDoor2 sel_313:)
	)
	
	(method (sel_606)
		(super sel_606: 47 126 66 113 85 120 68 132)
	)
)

(instance thudSound of Sound
	(properties
		sel_20 {thudSound}
		sel_99 5
		sel_40 80
	)
)
