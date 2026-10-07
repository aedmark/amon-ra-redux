;;; Sierra Script 1.0 - (do not remove this comment)
(script# 155)
(include sci.sh)
(use Main)
(use LBRoom)
(use RTRandCycle)
(use RandCycle)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm155 0
	Laura 2
)

(instance rm155 of LBRoom
	(properties
		sel_20 {rm155}
		sel_408 155
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 1155 156 157 155)
		(self sel_414: 92)
		(super sel_110:)
		(gGameMusic2 sel_40: 151 sel_99: 1 sel_3: -1 sel_39:)
		(grass sel_110: sel_317:)
		(moon sel_110: sel_317:)
		(cloud1 sel_110: sel_317:)
		(cloud2 sel_110: sel_317:)
		(blue sel_110: sel_317:)
		(lauraArm sel_110: sel_244: 15 sel_161: RandCycle)
		(fan sel_110: sel_161: Fwd)
		(trees1 sel_110: sel_146: sMoveTrees1)
		(trees2 sel_110: sel_146: sMoveTrees2)
		(global2 sel_146: sCartoon)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(gGameMusic2 sel_170: 0 30 12 1)
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
				((ScriptID 1900 15) sel_203: 1)
				(Laura sel_203: 1)
				(= sel_139 60)
			)
			(1
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(2
				(global2 sel_399: 160)
				(self sel_111:)
			)
		)
	)
)

(instance sMoveTrees1 of Script
	(properties
		sel_20 {sMoveTrees1}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(trees1
					sel_155: 2
					sel_51: 15
					sel_52: 15
					sel_312: MoveTo 365 160 self
				)
			)
			(1
				(sel_42 sel_1: 0 sel_0: 79)
				(self sel_144: 0)
			)
		)
	)
)

(instance sMoveTrees2 of Script
	(properties
		sel_20 {sMoveTrees2}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(trees2
					sel_155: 2
					sel_51: 15
					sel_52: 15
					sel_312: MoveTo 438 160 self
				)
			)
			(1
				(sel_42 sel_1: 0 sel_0: 79)
				(self sel_144: 0)
			)
		)
	)
)

(instance trees1 of Actor
	(properties
		sel_20 {trees1}
		sel_0 74
		sel_2 155
		sel_3 2
		sel_60 3
		sel_14 16400
		sel_53 5
	)
)

(instance trees2 of Actor
	(properties
		sel_20 {trees2}
		sel_0 74
		sel_2 155
		sel_3 2
		sel_4 1
		sel_60 3
		sel_14 16400
		sel_53 5
	)
)

(instance fan of Prop
	(properties
		sel_20 {fan}
		sel_1 157
		sel_0 35
		sel_2 157
		sel_60 14
		sel_14 16
	)
)

(instance lauraArm of Prop
	(properties
		sel_20 {lauraArm}
		sel_1 144
		sel_0 131
		sel_2 156
	)
)

(instance Laura of Talker
	(properties
		sel_20 {Laura}
		sel_1 0
		sel_0 0
		sel_2 1155
		sel_3 3
		sel_291 0
		sel_537 150
		sel_26 15
		sel_549 10
		sel_550 10
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		sel_20 {lauraBust}
		sel_2 1155
		sel_3 1
	)
)

(instance lauraEyes of Prop
	(properties
		sel_20 {lauraEyes}
		sel_6 85
		sel_7 180
		sel_2 1155
		sel_3 2
	)
)

(instance lauraMouth of Prop
	(properties
		sel_20 {lauraMouth}
		sel_6 90
		sel_7 180
		sel_2 1155
	)
)

(instance grass of View
	(properties
		sel_20 {grass}
		sel_1 142
		sel_0 87
		sel_2 155
		sel_3 1
		sel_60 2
		sel_14 16400
	)
)

(instance moon of View
	(properties
		sel_20 {moon}
		sel_1 140
		sel_0 60
		sel_2 155
		sel_60 1
		sel_14 16400
	)
)

(instance blue of View
	(properties
		sel_20 {blue}
		sel_1 34
		sel_0 71
		sel_2 155
		sel_3 3
		sel_4 1
		sel_60 1
		sel_14 16400
	)
)

(instance cloud1 of View
	(properties
		sel_20 {cloud1}
		sel_1 148
		sel_0 48
		sel_2 155
		sel_3 3
		sel_60 1
		sel_14 16400
	)
)

(instance cloud2 of View
	(properties
		sel_20 {cloud2}
		sel_1 26
		sel_0 47
		sel_2 155
		sel_3 3
		sel_60 1
		sel_14 16400
	)
)
