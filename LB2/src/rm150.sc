;;; Sierra Script 1.0 - (do not remove this comment)
(script# 150)
(include sci.sh)
(use Main)
(use LBRoom)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm150 0
)

(instance rm150 of LBRoom
	(properties
		sel_20 {rm150}
		sel_408 150
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 151 150)
		(proc958_0 132 150)
		(self sel_414: 92)
		(super sel_110:)
		(gSel_608 sel_40: 150 sel_99: 1 sel_3: -1 sel_39:)
		(lauraTrain sel_110:)
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
				(lauraTrain sel_312: MoveTo -245 56 self)
				(= sel_137 2)
			)
			(1
				(creditTitle sel_110: sel_312: MoveTo 35 107 self)
				(creditName sel_110: sel_312: MoveTo 35 151 self)
			)
			(2 0)
			(3 (= sel_137 3))
			(4
				(creditTitle sel_312: MoveTo -232 107 self)
				(creditName sel_312: MoveTo -250 151 self)
			)
			(5 0)
			(6 (= sel_137 3))
			(7
				(creditTitle
					sel_153: 333 130
					sel_3: 5
					sel_312: MoveTo -479 130 self
				)
				(creditName
					sel_153: 590 130
					sel_3: 5
					sel_312: MoveTo -222 130 self
				)
			)
			(8 0)
			(9 (= sel_137 3))
			(10
				(creditTitle
					sel_153: -236 119
					sel_3: 6
					sel_312: MoveTo 42 119 self
				)
				(creditName
					sel_153: -135 146
					sel_3: 6
					sel_312: MoveTo 143 146 self
				)
			)
			(11 0)
			(12 (= sel_137 3))
			(13
				(creditTitle sel_312: MoveTo -246 119 self)
				(creditName sel_312: MoveTo -145 146 self)
			)
			(14 0)
			(15 0)
			(16
				(global2 sel_399: 155)
				(self sel_111:)
			)
		)
	)
)

(instance lauraTrain of Actor
	(properties
		sel_20 {lauraTrain}
		sel_1 300
		sel_0 56
		sel_2 150
		sel_53 10
	)
)

(instance creditTitle of Actor
	(properties
		sel_20 {creditTitle}
		sel_1 35
		sel_0 200
		sel_2 151
		sel_3 4
		sel_14 26624
		sel_53 0
	)
)

(instance creditName of Actor
	(properties
		sel_20 {creditName}
		sel_1 35
		sel_0 244
		sel_2 151
		sel_3 4
		sel_4 1
		sel_14 26624
		sel_53 0
	)
)
