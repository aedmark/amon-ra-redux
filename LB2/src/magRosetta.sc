;;; Sierra Script 1.0 - (do not remove this comment)
(script# 456)
(include sci.sh)
(use Main)
(use CueObj)
(use Game)

(public
	magRosetta 0
)

(instance magRosetta of Rm
	(properties
		sel_20 {magRosetta}
		sel_408 780
	)
	
	(method (sel_110)
		(if (gTimers sel_122: (ScriptID 90 15))
			((ScriptID 90 15) sel_42: self)
		)
		(self sel_414: 90)
		(super sel_110:)
		(bigRosetta sel_110:)
	)
	
	(method (sel_145)
		((ScriptID 90 15) sel_162: self 10 0 0 global125)
	)
	
	(method (sel_399)
		(if (gTimers sel_122: (ScriptID 90 15))
			(= sel_135 0)
			((ScriptID 90 15) sel_42: (ScriptID 90 15))
		)
		(gGameMusic2 sel_170: 127 20 20 0)
		(super sel_399: &rest)
	)
)

(instance bigRosetta of Feature
	(properties
		sel_20 {bigRosetta}
		sel_0 190
		sel_6 50
		sel_7 50
		sel_8 145
		sel_9 210
	)
	
	(method (sel_110)
		(gLb2KDH sel_129: self)
		(gLb2MDH sel_129: self)
		(gGameMusic2 sel_170: 80 20 20 0)
		(gIconBar sel_233: 7)
		(super sel_110: &rest)
		(gIconBar sel_207: (gIconBar sel_64: 1) sel_233:)
		(if (== gGSel_40 454)
			(DrawPic 455 dpOPEN_NO_TRANSITION)
		else
			(DrawPic 521 dpOPEN_NO_TRANSITION)
		)
		(gGame sel_197: 996)
		(if (== gGSel_40 454)
			(SetCursor 2 79 55 239 144 86 0 0 456 53)
		else
			(SetCursor 2 79 55 239 144 86 0 0 527 53)
		)
		(Animate (gSel_561 sel_24?) 0)
	)
	
	(method (sel_111)
		(gLb2KDH sel_81: self)
		(gLb2MDH sel_81: self)
		(super sel_111: &rest)
		(gIconBar sel_177: 7)
		(global2 sel_399: gGSel_40)
	)
	
	(method (sel_133 param1)
		(if
		(or (== (param1 sel_31?) 1) (== (param1 sel_31?) 4))
			(SetCursor -1)
			(gGame sel_197: ((gIconBar sel_207?) sel_33?) 1)
			(param1 sel_73: 1)
			(self sel_111:)
			(gIconBar sel_177:)
		)
	)
)
