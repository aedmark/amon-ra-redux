;;; Sierra Script 1.0 - (do not remove this comment)
(script# 330)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm330 0
	Laura 2
	Steve 12
)

(local
	local0 =  1
)
(instance rm330 of LBRoom
	(properties
		sel_20 {rm330}
		sel_213 7
		sel_408 330
		sel_340 125
		sel_409 335
		sel_411 250
		sel_107 400
		sel_108 78
	)
	
	(method (sel_110)
		(proc958_0 128 1410 1411 330 331 213)
		(proc958_0 132 332 330 40)
		(proc958_0 129 415 410)
		(gEgo
			sel_585: (if (gEgo sel_584?) 831 else 830)
			sel_110:
		)
		(switch gGSel_40
			(sel_409
				(gEgo sel_153: 158 146 sel_14: (| (gEgo sel_14?) $4000))
				(if
					(not
						(if (and (== global123 2) (proc0_10 8))
							(not (proc0_2 133))
						)
					)
					(gSel_608 sel_40: 330 sel_99: 1 sel_3: 1 sel_39:)
				)
				(if
					(and
						(== global123 2)
						(proc0_10 8)
						(not (proc0_2 133))
					)
					(steve sel_110: sel_3: 1 sel_161: Walk)
					(gEgo sel_320: 179)
					(global2 sel_146: sKissAndHug)
				else
					(gGame sel_588:)
					(gEgo sel_320: 179)
				)
			)
			(else 
				(gSel_608 sel_40: 330 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo sel_153: 178 136)
				(gEgo sel_320: 179)
				(if (gEgo sel_584?)
					(taxi sel_153: 196 161 sel_110: sel_313:)
					(global2 sel_146: sTaxiLeave)
					(gGame sel_587:)
				else
					(gGame sel_588:)
				)
			)
		)
		(if (> global123 1) (Palette palSET_INTENSITY 0 255 60))
		(super sel_110:)
		(gGameMusic2 sel_40: 333 sel_99: 1 sel_3: -1 sel_39:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 3
					sel_110:
						0
						143
						0
						169
						62
						162
						106
						158
						178
						152
						196
						144
						305
						139
						319
						139
						319
						127
						277
						128
						270
						134
						239
						134
						212
						116
						166
						116
						150
						116
						154
						131
						110
						140
						62
						144
						32
						139
						0
						141
					sel_117:
				)
		)
		(larch sel_110:)
		(lawn1 sel_110:)
		(lawn2 sel_110:)
		(car1 sel_110:)
		(car2 sel_110:)
		(clouds sel_110:)
		(dome sel_110:)
		(entrance sel_110:)
		(bigWindow sel_110:)
		(sidewalk sel_110:)
		(steps sel_110:)
		(if (< global123 2) (taxi sel_110: sel_313:))
		(street sel_110:)
		(fountain1 sel_110: sel_161: Fwd)
		(fountain2 sel_110: sel_161: Fwd)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 256) (global2 sel_146: sHitEdgeScreen))
		)
	)
	
	(method (sel_111)
		(carSound sel_111:)
		(gSel_608 sel_170: 0 30 12 1)
		(gGameMusic2 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if local0
					(gLb2Messager sel_295: 7 1 1)
					(= local0 0)
				else
					(gLb2Messager sel_295: 7 1 2)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sHitEdgeScreen of Script
	(properties
		sel_20 {sHitEdgeScreen}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gLb2Messager sel_295: 4 3 0 0 self 91)
			)
			(1
				(if (> (gEgo sel_55?) 180)
					(gEgo sel_253: 90)
				else
					(gEgo sel_253: 270)
				)
				(gEgo sel_312: MoveFwd 10 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sTaxiLeave of Script
	(properties
		sel_20 {sTaxiLeave}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(taxi sel_312: MoveTo 369 125 self)
			)
			(1
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sInTaxi of Script
	(properties
		sel_20 {sInTaxi}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 146 151 self)
			)
			(1
				(carSound sel_39:)
				(= sel_139 30)
			)
			(2
				(gEgo sel_312: MoveTo 146 163 self)
			)
			(3
				(gEgo sel_102:)
				(= sel_136 2)
			)
			(4 (global2 sel_399: 250))
		)
	)
)

(instance sKissAndHug of Script
	(properties
		sel_20 {sKissAndHug}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 58 150 self)
			)
			(1
				(proc0_5 gEgo steve)
				(proc0_5 steve gEgo)
				(= sel_137 4)
			)
			(2
				(gGame sel_87: 1 133)
				(global2 sel_408: 780 sel_422: closeUp self)
			)
			(3
				(gSel_561 sel_119: 102)
				(= sel_136 2)
			)
			(4
				(global2 sel_417: 330)
				(Palette palSET_INTENSITY 0 255 60)
				(gSel_561 sel_119: 216)
				(steve sel_155: 0)
				(gEgo sel_312: PolyPath 158 146 self)
			)
			(5
				(DrawPic 780 dpOPEN_FADEPALETTE)
				(gSel_561 sel_119: 102)
				(= sel_136 2)
			)
			(6
				(Palette palSET_INTENSITY 0 255 100)
				(global2 sel_399: 350)
				(self sel_111:)
			)
		)
	)
)

(instance sCloseUp of Script
	(properties
		sel_20 {sCloseUp}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1
				(gSel_608 sel_40: 332 sel_99: 1 sel_3: -1 sel_39:)
				(gLb2Messager sel_295: 6 0 0 0 self 330)
				(gGameMusic2 sel_170: 0 12 30 0)
			)
			(2
				(DrawPic 415 -32758)
				(gSel_608 sel_40: 334 sel_99: 1 sel_3: 1 sel_39:)
				(= sel_137 4)
			)
			(3
				(DrawPic 410 -32758)
				(= sel_139 30)
			)
			(4
				(gLb2Messager sel_295: 12 0 0 0 self 330)
			)
			(5
				(gGameMusic2 sel_170: 127 12 30 0)
				(closeUp sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		sel_20 {taxi}
		sel_1 139
		sel_0 146
		sel_213 5
		sel_2 213
		sel_4 2
		sel_60 15
		sel_14 16400
		sel_53 0
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (global2 sel_146: sInTaxi))
			(else  (super sel_300: param1))
		)
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 156
		sel_0 142
		sel_2 331
		sel_14 16384
	)
	
	(method (sel_57)
		(= sel_4 (gEgo sel_4?))
		(= sel_1 (- (gEgo sel_1?) 2))
		(= sel_0 (- (gEgo sel_0?) 4))
		(super sel_57: &rest)
	)
)

(instance fountain1 of Prop
	(properties
		sel_20 {fountain1}
		sel_1 77
		sel_0 137
		sel_213 4
		sel_2 330
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(gLb2Messager sel_295: 4 6 3)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance fountain2 of Prop
	(properties
		sel_20 {fountain2}
		sel_1 263
		sel_0 126
		sel_213 4
		sel_2 330
		sel_3 1
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(gLb2Messager sel_295: 4 6 3)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance Laura of Talker
	(properties
		sel_20 {Laura}
		sel_1 0
		sel_0 0
		sel_2 1411
		sel_3 3
		sel_291 0
		sel_537 250
		sel_26 15
		sel_549 15
		sel_550 120
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		sel_20 {lauraBust}
		sel_2 1411
		sel_3 1
	)
)

(instance lauraEyes of Prop
	(properties
		sel_20 {lauraEyes}
		sel_6 65
		sel_7 182
		sel_2 1411
		sel_3 2
		sel_14 16384
	)
)

(instance lauraMouth of Prop
	(properties
		sel_20 {lauraMouth}
		sel_6 70
		sel_7 182
		sel_2 1411
		sel_14 16384
	)
)

(instance Steve of Talker
	(properties
		sel_20 {Steve}
		sel_1 0
		sel_0 0
		sel_2 1410
		sel_3 3
		sel_291 0
		sel_537 250
		sel_26 15
		sel_549 15
		sel_550 120
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: steveBust steveEyes steveMouth &rest)
	)
)

(instance steveBust of Prop
	(properties
		sel_20 {steveBust}
		sel_2 1410
		sel_3 1
	)
)

(instance steveEyes of Prop
	(properties
		sel_20 {steveEyes}
		sel_6 50
		sel_7 140
		sel_2 1410
		sel_3 2
		sel_14 16384
	)
)

(instance steveMouth of Prop
	(properties
		sel_20 {steveMouth}
		sel_6 62
		sel_7 130
		sel_2 1410
		sel_14 16384
	)
)

(instance lawn1 of Feature
	(properties
		sel_20 {lawn1}
		sel_1 27
		sel_0 130
		sel_213 8
		sel_6 127
		sel_8 134
		sel_9 54
		sel_301 40
	)
)

(instance lawn2 of Feature
	(properties
		sel_20 {lawn2}
		sel_1 297
		sel_0 122
		sel_213 8
		sel_6 119
		sel_7 275
		sel_8 125
		sel_9 319
		sel_301 40
	)
)

(instance car1 of Feature
	(properties
		sel_20 {car1}
		sel_0 3
		sel_213 2
		sel_6 148
		sel_8 174
		sel_9 69
	)
)

(instance car2 of Feature
	(properties
		sel_20 {car2}
		sel_0 3
		sel_213 2
		sel_6 126
		sel_7 204
		sel_8 143
		sel_9 276
	)
)

(instance larch of Feature
	(properties
		sel_20 {larch}
		sel_0 3
		sel_213 3
		sel_6 78
		sel_7 44
		sel_8 110
		sel_9 92
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(gLb2Messager sel_295: 3 6 3)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance clouds of Feature
	(properties
		sel_20 {clouds}
		sel_0 3
		sel_213 11
		sel_302 128
	)
)

(instance dome of Feature
	(properties
		sel_20 {dome}
		sel_0 3
		sel_213 13
		sel_302 8
	)
)

(instance entrance of Feature
	(properties
		sel_20 {entrance}
		sel_0 3
		sel_213 14
		sel_302 32
	)
)

(instance bigWindow of Feature
	(properties
		sel_20 {bigWindow}
		sel_0 3
		sel_213 15
		sel_302 2
	)
)

(instance sidewalk of Feature
	(properties
		sel_20 {sidewalk}
		sel_0 3
		sel_213 1
		sel_302 4
	)
)

(instance steps of Feature
	(properties
		sel_20 {steps}
		sel_0 3
		sel_213 9
		sel_302 16384
	)
)

(instance street of Feature
	(properties
		sel_20 {street}
		sel_0 3
		sel_213 10
		sel_302 64
	)
)

(instance closeUp of Inset
	(properties
		sel_20 {closeUp}
		sel_408 410
		sel_28 -32758
		sel_560 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(self sel_146: sCloseUp)
	)
)

(instance carSound of Sound
	(properties
		sel_20 {carSound}
		sel_99 5
		sel_40 40
	)
)
