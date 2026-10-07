;;; Sierra Script 1.0 - (do not remove this comment)
(script# 105)
(include sci.sh)
(use Main)
(use LBRoom)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	logo 0
)

(instance logo of LBRoom
	(properties
		sel_20 {logo}
		sel_408 105
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 108)
		(proc958_0 129 780)
		(proc958_0 132 105)
		(self sel_414: 92)
		(global2 sel_417: 780)
		(super sel_110:)
		(sparkle sel_110:)
		(gUser sel_237: 0 sel_347: 0)
		(gSel_608 sel_40: 105 sel_99: 1 sel_3: 1 sel_39:)
		(self sel_146: sRunIt)
	)
)

(instance sRunIt of Script
	(properties
		sel_20 {sRunIt}
	)
	
	(method (sel_57)
		(Palette palANIMATE 95 224 1)
		(super sel_57: &rest)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(Palette palSET_INTENSITY 0 254 0)
				(global2 sel_417: 105 10)
				(= sel_136 1)
			)
			(1
				(gGame sel_587: sel_197: 996 1 304 172)
				(= sel_137 6)
			)
			(2
				(if (== (gSel_608 sel_165?) 20)
					(sparkle sel_161: End self)
				else
					(-- sel_29)
					(= sel_136 1)
				)
			)
			(3
				(if (== (gSel_608 sel_165?) 30)
					(sparkle
						sel_1: 60
						sel_0: 145
						sel_3: 1
						sel_4: 0
						sel_161: End self
					)
				else
					(-- sel_29)
					(= sel_136 1)
				)
			)
			(4
				(if
					(and
						(== (sparkle sel_4?) (sparkle sel_246:))
						(== (gSel_608 sel_165?) -1)
					)
					(sparkle sel_111:)
					(= sel_136 1)
				else
					(-- sel_29)
					(= sel_136 1)
				)
			)
			(5
				(global2 sel_399: 100)
				(self sel_111:)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		sel_20 {sparkle}
		sel_1 121
		sel_0 54
		sel_2 108
		sel_60 15
		sel_14 16
	)
)
