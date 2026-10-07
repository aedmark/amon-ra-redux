;;; Sierra Script 1.0 - (do not remove this comment)
(script# 110)
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
	rm110 0
)

(instance rm110 of LBRoom
	(properties
		sel_20 {rm110}
		sel_408 110
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 151 110 111 112 113)
		(proc958_0 132 110 112)
		(self sel_414: 92)
		(super sel_110:)
		(global2
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						138
						90
						129
						183
						175
						182
						175
						189
						0
						189
						0
						0
						319
						0
						319
						114
						238
						117
						223
						63
						221
						89
					sel_117:
				)
		)
		(thedoor sel_110:)
		(mirror sel_110:)
		(badGuy sel_110:)
		(inTrunk sel_110:)
		(lid sel_110:)
		(gSel_608
			sel_40: 110
			sel_99: 1
			sel_3: -1
			sel_39: sCartoon
		)
		(cond 
			((> global87 12) 0)
			((> global87 8)
				(creditTitle sel_338: 7 7)
				(creditName sel_338: 7 7)
				(badGuy sel_53: 4 sel_244: 4)
			)
			(else
				(creditTitle sel_338: 15 15)
				(creditName sel_338: 15 15)
				(badGuy sel_53: 3 sel_244: 3)
			)
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
			(0 (= sel_137 2))
			(1 (thedoor sel_161: End self))
			(2 (= sel_139 120))
			(3 (thedoor sel_161: Beg self))
			(4
				(badGuy
					sel_155: 0
					sel_161: Walk
					sel_63: 15
					sel_312: PolyPath 130 91 self
				)
				(thedoor sel_111:)
			)
			(5
				(inTrunk sel_102:)
				(badGuy
					sel_3: 1
					sel_4: 0
					sel_153: 122 91
					sel_63: -1
					sel_161: End self
				)
				(gNarrator sel_1: 20 sel_0: 160 sel_203: 1)
			)
			(6
				(gSel_608 sel_40: 112 sel_99: 1 sel_3: 1 sel_39: sCartoon)
				(gLb2Messager sel_295: 1 0 0 0)
				(badGuy sel_161: CT 9 -1 self)
			)
			(7 (badGuy sel_161: End self))
			(8
				(badGuy sel_161: CT 11 -1)
				(= sel_139 30)
			)
			(9
				(badGuy sel_161: End)
				(= sel_139 120)
			)
			(10
				(if gSel_201 (gSel_201 sel_111:))
				(gNarrator sel_111:)
				(badGuy sel_3: 2 sel_4: 0 sel_161: End self)
			)
			(11
				(badGuy
					sel_2: 113
					sel_3: 0
					sel_4: 0
					sel_153: 150 87
					sel_161: End self
				)
			)
			(12
				(badGuy
					sel_2: 112
					sel_3: 0
					sel_4: 0
					sel_153: 150 87
					sel_161: End self
				)
			)
			(13
				(mirror sel_161: End self)
				(badGuy
					sel_3: 1
					sel_4: 0
					sel_153: 151 94
					sel_161: Walk
					sel_312: PolyPath 234 93 self
				)
			)
			(14 (mirror sel_111:))
			(15
				(badGuy
					sel_3: 2
					sel_4: 0
					sel_153: 234 91
					sel_161: End self
				)
			)
			(16
				(inTrunk sel_3: 0 sel_153: 247 64 sel_63: 4 sel_216:)
				(badGuy
					sel_3: 3
					sel_4: 0
					sel_153: 242 93
					sel_63: 8
					sel_161: CT 5 1 self
				)
			)
			(17
				(badGuy sel_161: CT 9 1 self)
				(lid sel_161: End)
			)
			(18
				(inTrunk sel_111:)
				(badGuy
					sel_3: 4
					sel_4: 0
					sel_153: 227 88
					sel_63: 8
					sel_161: End self
				)
			)
			(19
				(badGuy
					sel_3: 5
					sel_4: 5
					sel_153: 219 95
					sel_161: Walk
					sel_312: PolyPath 300 257 self
				)
			)
			(20 (= sel_137 3))
			(21
				(badGuy sel_111:)
				(creditTitle sel_110: sel_312: MoveTo 53 124 self)
				(creditName sel_110: sel_312: MoveTo 110 152 self)
			)
			(22 0)
			(23 (= sel_137 4))
			(24
				(creditTitle sel_312: MoveTo 383 124 self)
				(creditName sel_312: MoveTo 383 152 self)
			)
			(25 0)
			(26
				(if (== (gSel_608 sel_165?) -1) (= sel_136 1))
			)
			(27 (global2 sel_399: 120))
		)
	)
)

(instance badGuy of Actor
	(properties
		sel_20 {badGuy}
		sel_1 300
		sel_0 257
		sel_52 3
		sel_2 111
		sel_14 16384
		sel_51 4
	)
)

(instance thedoor of Prop
	(properties
		sel_20 {thedoor}
		sel_1 247
		sel_0 188
		sel_2 110
		sel_3 4
		sel_14 16384
	)
)

(instance lid of Prop
	(properties
		sel_20 {lid}
		sel_1 287
		sel_0 91
		sel_2 110
		sel_3 1
		sel_60 8
		sel_14 16400
	)
)

(instance mirror of Prop
	(properties
		sel_20 {mirror}
		sel_1 179
		sel_0 39
		sel_2 110
		sel_3 3
	)
)

(instance creditTitle of Actor
	(properties
		sel_20 {creditTitle}
		sel_1 375
		sel_0 124
		sel_2 151
		sel_3 2
		sel_14 2048
		sel_53 0
	)
)

(instance creditName of Actor
	(properties
		sel_20 {creditName}
		sel_1 432
		sel_0 152
		sel_2 151
		sel_3 2
		sel_4 1
		sel_14 2048
		sel_53 0
	)
)

(instance inTrunk of View
	(properties
		sel_20 {inTrunk}
		sel_1 100
		sel_0 62
		sel_2 110
		sel_3 2
		sel_60 6
		sel_14 16400
	)
)
