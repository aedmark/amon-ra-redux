;;; Sierra Script 1.0 - (do not remove this comment)
(script# 775)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use n958)
(use View)
(use Obj)

(public
	rm775 0
	Steve 12
)

(local
	local0
	local1 =  100
)
(instance rm775 of LBRoom
	(properties
		sel_20 {rm775}
		sel_408 120
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 123 121 1125 125)
		(proc958_0 132 121 120)
		(gEgo sel_110: sel_585: sel_320: 167 sel_153: 240 160)
		(super sel_110:)
		(gIconBar sel_233:)
		(gGame sel_197: 996)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 3
					sel_110: 84 154 83 176 183 176 241 168 241 149 199 149 126 149 91 154
					sel_117:
				)
		)
		(gSel_608 sel_40: 332 sel_99: 1 sel_3: -1 sel_39:)
		(steve sel_110: sel_320: 158)
		(global2 sel_146: sTalkSteve)
	)
)

(instance sTalkSteve of Script
	(properties
		sel_20 {sTalkSteve}
	)
	
	(method (sel_57)
		(if (and local0 local1)
			(Palette palSET_INTENSITY 0 255 (-- local1))
			(if (not local1) (self sel_145:))
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 197 155 self)
				((ScriptID 1881 2)
					sel_1: 203
					sel_0: 17
					sel_549: -180
					sel_550: 0
				)
			)
			(1 (proc0_5 gEgo steve self))
			(2
				(togetherView sel_110: sel_63: 14)
				(= sel_136 4)
			)
			(3
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(4
				(global2 sel_422: inDagger)
				(= sel_137 4)
			)
			(5
				(inDagger sel_111:)
				(= sel_136 2)
			)
			(6
				(gLb2Messager sel_295: 1 0 1 0 self)
			)
			(7
				(gLb2Messager sel_295: 1 0 2 0 self)
				(gSel_608 sel_40: 334 sel_99: 1 sel_3: 1 sel_39: self)
			)
			(8 (= local0 1))
			(9 0)
			(10
				(togetherView sel_102:)
				(= sel_136 4)
				(global2 sel_399: 785)
				(self sel_111:)
			)
		)
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 184
		sel_0 145
		sel_2 121
		sel_3 5
	)
)

(instance Steve of Talker
	(properties
		sel_20 {Steve}
		sel_1 78
		sel_0 100
		sel_2 1125
		sel_3 3
		sel_291 0
		sel_537 110
		sel_26 15
		sel_549 81
		sel_550 -90
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: tSteveBust tSteveEyes tSteveMouth &rest)
	)
)

(instance tSteveMouth of Prop
	(properties
		sel_20 {tSteveMouth}
		sel_6 14
		sel_7 4
		sel_2 1125
	)
)

(instance tSteveEyes of Prop
	(properties
		sel_20 {tSteveEyes}
		sel_6 9
		sel_7 6
		sel_2 1125
		sel_3 2
	)
)

(instance tSteveBust of View
	(properties
		sel_20 {tSteveBust}
		sel_2 1125
		sel_3 1
	)
)

(instance togetherView of View
	(properties
		sel_20 {togetherView}
		sel_1 25
		sel_0 80
		sel_2 125
	)
)

(instance inDagger of Inset
	(properties
		sel_20 {inDagger}
		sel_2 123
		sel_1 95
		sel_0 57
		sel_560 1
	)
)
