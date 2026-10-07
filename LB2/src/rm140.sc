;;; Sierra Script 1.0 - (do not remove this comment)
(script# 140)
(include sci.sh)
(use Main)
(use LBRoom)
(use Scaler)
(use PolyPath)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm140 0
)

(instance rm140 of LBRoom
	(properties
		sel_20 {rm140}
		sel_408 140
		sel_28 10
		sel_107 7
		sel_108 54
	)
	
	(method (sel_110)
		(proc958_0 128 151 830 142)
		(proc958_0 132 140)
		(self sel_414: 92)
		(gEgo
			sel_110:
			sel_2: 830
			sel_3: 3
			sel_4: 1
			sel_153: 167 158
			sel_320: Scaler 125 0 190 24
			sel_244: 6
		)
		(super sel_110:)
		(dad sel_110:)
		(gSel_608 sel_40: 140 sel_99: 1 sel_3: -1 sel_39:)
		(self sel_146: sCartoon)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				((ScriptID 1880 1)
					sel_291: 0
					sel_1: 5
					sel_0: 5
					sel_549: 10
					sel_550: 140
					sel_537: 280
				)
				((ScriptID 1881 2)
					sel_291: 0
					sel_1: 211
					sel_0: 5
					sel_549: -196
					sel_550: 140
					sel_537: 280
				)
				(= sel_136 1)
			)
			(1
				(gNarrator sel_1: 60 sel_0: 100 sel_538: 0)
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(2
				(gEgo sel_312: PolyPath 167 145 self)
			)
			(3
				(gEgo sel_102:)
				(dad sel_3: 0 sel_161: End self)
			)
			(4 (= sel_137 2))
			(5 (dad sel_161: Beg self))
			(6
				(gEgo sel_216: sel_155: 4 sel_312: MoveTo 299 340 self)
				(= sel_136 1)
			)
			(7
				(dad
					sel_3: 1
					sel_4: 0
					sel_153: 168 143
					sel_244: 10
					sel_161: CT 6 1 self
				)
			)
			(8 (= sel_139 20))
			(9 (dad sel_161: CT 4 -1 self))
			(10 (= sel_139 20))
			(11 (dad sel_161: CT 6 1 self))
			(12 (dad sel_161: Beg self))
			(13 0)
			(14
				(dad sel_317:)
				(creditTitle
					sel_110:
					sel_63: 15
					sel_312: MoveTo 50 82 self
				)
				(creditName
					sel_110:
					sel_63: 15
					sel_312: MoveTo 107 125 self
				)
			)
			(15 0)
			(16 (= sel_137 3))
			(17
				(creditTitle sel_312: MoveTo -200 82 self)
				(creditName sel_312: MoveTo 107 209 self)
			)
			(18 0)
			(19
				(global2 sel_399: 150)
				(self sel_111:)
			)
		)
	)
)

(instance dad of Actor
	(properties
		sel_20 {dad}
		sel_1 170
		sel_0 143
		sel_2 142
		sel_3 1
		sel_14 16384
		sel_244 10
	)
)

(instance creditTitle of Actor
	(properties
		sel_20 {creditTitle}
		sel_1 50
		sel_0 -2
		sel_2 151
		sel_3 3
		sel_14 26624
		sel_53 0
	)
)

(instance creditName of Actor
	(properties
		sel_20 {creditName}
		sel_1 230
		sel_0 125
		sel_2 151
		sel_3 3
		sel_4 1
		sel_14 26624
		sel_53 0
	)
)
