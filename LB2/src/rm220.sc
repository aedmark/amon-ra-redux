;;; Sierra Script 1.0 - (do not remove this comment)
(script# 220)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use MessageObj)
(use RTRandCycle)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm220 0
	Laura220 2
	Sam220 3
)

(local
	[local0 65] = [-1 1 0 0 1 0 0 0 -1 1 0 0 2 0 0 0 -1 1 0 0 3 0 0 0 -1 1 0 0 4 0 0 0 -1 1 0 0 5 0 0 0 -1 1 0 0 6 0 0 0 -1 1 0 0 7 0 0 0 -1 1 0 0 8]
	[local65 49] = [-1 1 0 0 9 0 0 0 -1 1 0 0 10 0 0 0 -1 1 0 0 11 0 0 0 -1 1 0 0 12 0 0 0 -1 1 0 0 13 0 0 0 -1 1 0 0 14]
)
(instance rm220 of LBRoom
	(properties
		sel_20 {rm220}
		sel_408 220
	)
	
	(method (sel_110)
		(proc958_0 128 221 220 1220 1221)
		(Load rsSOUND 220)
		(Load rsPIC 225)
		(self sel_414: 92)
		(super sel_110:)
		(WrapMusic sel_111:)
		(gSel_608 sel_40: 220 sel_3: -1 sel_99: 1 sel_39:)
		(fan sel_110: sel_161: Fwd)
		(shadowL sel_110: sel_146: sLeftShadow)
		(shadowR sel_110: sel_146: sRightShadow)
		(self sel_146: sCartoon)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 3))
			(1
				(gEgo sel_350: -1 2)
				(myConv sel_558: @local0 sel_110: self)
			)
			(2
				(global2 sel_422: inLauraPeeks)
				(= sel_137 5)
			)
			(3
				(gEgo sel_102:)
				(global2 sel_422: 0)
				(= sel_136 1)
			)
			(4
				(myConv sel_558: @local65 sel_110: self)
			)
			(5 (gSel_608 sel_170: self))
			(6 (global2 sel_399: 26))
		)
	)
)

(instance sRightShadow of Script
	(properties
		sel_20 {sRightShadow}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(shadowR sel_155: 1 sel_312: MoveTo 180 84 self)
			)
			(1 (= sel_137 (Random 3 6)))
			(2
				(shadowR sel_153: -20 89)
				(= sel_29 -1)
				(= sel_136 1)
			)
		)
	)
)

(instance sLeftShadow of Script
	(properties
		sel_20 {sLeftShadow}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 (Random 2 5)))
			(1
				(shadowL sel_155: 0 sel_312: MoveTo -30 89 self)
			)
			(2
				(shadowL sel_153: 175 85)
				(= sel_29 -1)
				(= sel_136 1)
			)
		)
	)
)

(instance shadowL of Actor
	(properties
		sel_20 {shadowL}
		sel_1 175
		sel_0 84
		sel_2 221
		sel_60 4
		sel_14 16400
	)
)

(instance shadowR of Actor
	(properties
		sel_20 {shadowR}
		sel_1 -20
		sel_0 89
		sel_2 221
		sel_3 1
		sel_60 4
		sel_14 16400
	)
)

(instance fan of Prop
	(properties
		sel_20 {fan}
		sel_1 10
		sel_0 177
		sel_2 220
	)
)

(instance inLauraPeeks of Inset
	(properties
		sel_20 {inLauraPeeks}
		sel_408 225
		sel_560 1
	)
)

(instance myConv of Conversation
	(properties
		sel_20 {myConv}
	)
)

(instance Sam220 of Talker
	(properties
		sel_20 {Sam220}
		sel_1 0
		sel_0 0
		sel_2 1220
		sel_3 3
		sel_291 0
		sel_537 200
		sel_203 1
		sel_26 15
		sel_549 10
		sel_550 10
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: 0 samEyes samMouth &rest)
	)
)

(instance samMouth of Prop
	(properties
		sel_20 {samMouth}
		sel_6 63
		sel_7 247
		sel_2 1220
	)
)

(instance samEyes of Prop
	(properties
		sel_20 {samEyes}
		sel_6 58
		sel_7 251
		sel_2 1220
		sel_3 2
	)
)

(instance Laura220 of Talker
	(properties
		sel_20 {Laura220}
		sel_1 0
		sel_0 0
		sel_2 1221
		sel_3 3
		sel_60 14
		sel_14 16
		sel_291 0
		sel_537 150
		sel_203 1
		sel_26 15
		sel_549 139
		sel_550 104
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: 0 0 lMouth &rest)
	)
)

(instance lMouth of Prop
	(properties
		sel_20 {lMouth}
		sel_6 100
		sel_7 117
		sel_2 1221
		sel_60 7
		sel_14 16
	)
)
