;;; Sierra Script 1.0 - (do not remove this comment)
(script# 190)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm190 0
)

(instance rm190 of LBRoom
	(properties
		sel_20 {rm190}
		sel_408 210
		sel_107 400
		sel_108 143
	)
	
	(method (sel_110)
		(proc958_0 128 809 210 284 212 213)
		(self sel_414: 92)
		(gEgo sel_585: 803 sel_110:)
		(super sel_110:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 3
					sel_110:
						319
						188
						319
						176
						197
						176
						188
						176
						170
						179
						156
						180
						88
						184
						80
						183
						73
						180
						46
						156
						17
						156
						23
						170
						49
						188
					sel_117:
				)
		)
		(frontDoor sel_110:)
		(taxiSign sel_110:)
		(person2
			sel_110:
			sel_51: 1
			sel_52: 1
			sel_155: 2
			sel_161: Walk
			sel_312: MoveTo -10 193
		)
		(person3
			sel_110:
			sel_51: 1
			sel_52: 1
			sel_155: 3
			sel_161: Walk
			sel_312: MoveTo 208 179
		)
		(person8
			sel_110:
			sel_51: 1
			sel_52: 1
			sel_155: 11
			sel_161: Walk
			sel_312: MoveTo 330 184
		)
		(car sel_110: sel_155: 0 sel_312: MoveTo 370 181)
		(global2 sel_146: sIntroCartoon)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(gGameMusic2 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sIntroCartoon of Script
	(properties
		sel_20 {sIntroCartoon}
	)
	
	(method (sel_57)
		(super sel_57:)
		(if
		(and (== (gSel_608 sel_40?) 94) (== sel_29 7))
			(self sel_145:)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_3: 7 sel_1: 71 sel_0: 185)
				((ScriptID 1881 2) sel_203: 1)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 57 181 self)
			)
			(2
				(gEgo sel_253: 1)
				(= sel_136 4)
			)
			(3
				(gEgo
					sel_2: 809
					sel_3: 3
					sel_153: 58 180
					sel_244: 10
					sel_53: 10
					sel_161: CT 6 1 self
				)
			)
			(4
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(5 (gEgo sel_161: End self))
			(6
				(gEgo sel_585: 803)
				(gEgo sel_312: PolyPath 40 175 self)
			)
			(7 (frontDoor sel_161: End))
			(8 (global2 sel_399: 220))
		)
	)
)

(instance frontDoor of Door
	(properties
		sel_20 {frontDoor}
		sel_1 39
		sel_0 167
		sel_303 36
		sel_304 175
		sel_2 210
		sel_589 220
		sel_597 29
		sel_598 172
		sel_599 0
		sel_600 0
	)
)

(instance taxiSign of View
	(properties
		sel_20 {taxiSign}
		sel_1 165
		sel_0 185
		sel_2 284
		sel_4 2
		sel_14 16384
	)
)

(instance person2 of Actor
	(properties
		sel_20 {person2}
		sel_1 140
		sel_0 180
		sel_2 212
		sel_3 2
		sel_14 16384
	)
)

(instance person3 of Actor
	(properties
		sel_20 {person3}
		sel_1 -10
		sel_0 190
		sel_2 212
		sel_3 3
		sel_14 16384
	)
)

(instance person8 of Actor
	(properties
		sel_20 {person8}
		sel_1 51
		sel_0 189
		sel_2 212
		sel_3 11
		sel_14 16384
	)
)

(instance car of Actor
	(properties
		sel_20 {car}
		sel_1 154
		sel_0 189
		sel_2 213
		sel_4 1
		sel_60 14
		sel_14 16400
	)
)
