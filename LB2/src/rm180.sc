;;; Sierra Script 1.0 - (do not remove this comment)
(script# 180)
(include sci.sh)
(use Main)
(use LBRoom)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm180 0
)

(instance rm180 of LBRoom
	(properties
		sel_20 {rm180}
		sel_408 180
		sel_28 10
		sel_107 145
		sel_108 126
	)
	
	(method (sel_110)
		(proc958_0 128 151 181 185)
		(proc958_0 132 94 180)
		(self sel_414: 92)
		(gEgo
			sel_2: 185
			sel_155: 5
			sel_1: 325
			sel_0: 195
			sel_51: 1
			sel_52: 1
			sel_63: -1
			sel_110:
		)
		(super sel_110:)
		(global2
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110: 305 189 222 168 319 175 319 189
					sel_117:
				)
		)
		(nyCar3 sel_317:)
		(nyCar4 sel_317:)
		(WrapMusic sel_110: 0 180 94)
		(nyCar1 sel_110: sel_146: sCarGo1)
		(p1 sel_110: sel_146: sP1Walk)
		(p2
			sel_110:
			sel_155: 1
			sel_161: Walk
			sel_312: PolyPath 31 220
		)
		(p3
			sel_110:
			sel_155: 2
			sel_161: Walk
			sel_312: PolyPath 137 172
		)
		(p4
			sel_110:
			sel_155: 4
			sel_161: Walk
			sel_312: PolyPath 206 206
		)
		(self sel_146: sCartoon)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_161: Walk sel_312: PolyPath 224 168 self)
			)
			(1
				((ScriptID 1881 2) sel_203: 1)
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(2
				(gEgo sel_155: 6 sel_312: PolyPath 245 168 self)
			)
			(3 (= sel_137 2))
			(4
				(gEgo sel_111:)
				(creditTitle
					sel_110:
					sel_153: 48 -20
					sel_63: 15
					sel_312: MoveTo 48 93 self
				)
				(creditName
					sel_110:
					sel_153: 62 245
					sel_63: 15
					sel_312: MoveTo 62 132 self
				)
			)
			(5 0)
			(6 (= sel_137 3))
			(7
				(creditTitle sel_312: MoveTo 48 -20 self)
				(creditName sel_312: MoveTo 62 210 self)
			)
			(8 0)
			(9
				(creditTitle
					sel_3: 8
					sel_153: -190 102
					sel_63: -1
					sel_312: MoveTo 50 102 self
				)
				(creditName
					sel_3: 8
					sel_153: -190 138
					sel_63: -1
					sel_312: MoveTo 50 138 self
				)
			)
			(10 0)
			(11 (= sel_137 3))
			(12
				(creditTitle sel_312: MoveTo 465 102 self)
				(creditName sel_312: MoveTo 456 138 self)
			)
			(13 0)
			(14
				(global2 sel_399: 190)
				(gGame sel_197: gWalkCursor)
				(self sel_111:)
			)
		)
	)
)

(instance sCarGo1 of Script
	(properties
		sel_20 {sCarGo1}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(nyCar1 sel_312: MoveTo -25 168 self)
			)
			(1
				(nyCar1
					sel_3: 0
					sel_4: 2
					sel_153: -25 182
					sel_312: MoveTo 120 158 self
				)
			)
			(2
				(nyCar1 sel_317:)
				(self sel_111:)
			)
		)
	)
)

(instance sP1Walk of Script
	(properties
		sel_20 {sP1Walk}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(p1
					sel_155: 0
					sel_161: Walk
					sel_312: PolyPath 136 170 self
				)
			)
			(1
				(p1
					sel_155: 3
					sel_153: 158 170
					sel_312: PolyPath 220 220 self
				)
			)
			(2
				(p1 sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance nyCar1 of Actor
	(properties
		sel_20 {nyCar1}
		sel_1 155
		sel_0 153
		sel_2 181
		sel_3 3
		sel_4 4
		sel_14 18432
	)
)

(instance p1 of Actor
	(properties
		sel_20 {p1}
		sel_1 197
		sel_0 198
		sel_52 1
		sel_2 185
		sel_51 1
	)
)

(instance p2 of Actor
	(properties
		sel_20 {p2}
		sel_1 138
		sel_0 168
		sel_52 1
		sel_2 185
		sel_3 1
		sel_51 1
	)
)

(instance p3 of Actor
	(properties
		sel_20 {p3}
		sel_1 186
		sel_0 198
		sel_52 1
		sel_2 185
		sel_3 2
		sel_51 1
	)
)

(instance p4 of Actor
	(properties
		sel_20 {p4}
		sel_1 155
		sel_0 166
		sel_52 1
		sel_2 185
		sel_3 4
		sel_51 1
	)
)

(instance creditTitle of Actor
	(properties
		sel_20 {creditTitle}
		sel_1 -156
		sel_0 102
		sel_2 151
		sel_3 7
		sel_14 26624
		sel_53 0
	)
)

(instance creditName of Actor
	(properties
		sel_20 {creditName}
		sel_1 -190
		sel_0 138
		sel_2 151
		sel_3 7
		sel_4 1
		sel_14 26624
		sel_53 0
	)
)

(instance nyCar3 of View
	(properties
		sel_20 {nyCar3}
		sel_1 235
		sel_0 153
		sel_2 181
		sel_3 2
		sel_14 18432
	)
)

(instance nyCar4 of View
	(properties
		sel_20 {nyCar4}
		sel_1 230
		sel_0 200
		sel_2 181
		sel_3 5
		sel_4 1
		sel_14 18432
	)
)
