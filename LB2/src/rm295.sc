;;; Sierra Script 1.0 - (do not remove this comment)
(script# 295)
(include sci.sh)
(use Main)
(use LBRoom)
(use RTRandCycle)
(use n958)
(use View)
(use Obj)

(public
	rm295 0
	myORiley 19
)

(instance rm295 of LBRoom
	(properties
		sel_20 {rm295}
		sel_408 295
		sel_411 290
	)
	
	(method (sel_110)
		(proc958_0 128 295 1295)
		(proc958_0 132 295)
		(super sel_110:)
		(gSel_608 sel_40: 295 sel_99: 1 sel_3: -1 sel_39:)
		(global2 sel_146: sInsideRoom)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sInsideRoom of Script
	(properties
		sel_20 {sInsideRoom}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 4))
			(1
				(gLb2Messager sel_295: 13 0 0 0 self)
			)
			(2
				(global2 sel_417: 780)
				(folderInset sel_110:)
				(= sel_136 1)
			)
			(3
				(gNarrator sel_1: 100 sel_0: 100)
				(gLb2Messager sel_295: 15 0 0 0 self)
			)
			(4
				(folderInset sel_111:)
				(proc0_3 43)
				(global2 sel_417: 295)
				(= sel_136 1)
			)
			(5
				(gLb2Messager sel_295: 14 0 0 0 self)
			)
			(6
				(global2 sel_399: 290)
				(self sel_111:)
			)
		)
	)
)

(instance myORiley of Talker
	(properties
		sel_20 {myORiley}
		sel_1 0
		sel_0 0
		sel_2 1295
		sel_3 3
		sel_291 0
		sel_537 280
		sel_26 15
		sel_549 10
		sel_550 140
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: oRileyBust 0 oRileyMouth &rest)
	)
)

(instance oRileyBust of Prop
	(properties
		sel_20 {oRileyBust}
		sel_2 1295
		sel_3 1
	)
)

(instance oRileyMouth of Prop
	(properties
		sel_20 {oRileyMouth}
		sel_6 36
		sel_7 254
		sel_2 1295
	)
)

(instance folderInset of View
	(properties
		sel_20 {folderInset}
		sel_1 5
		sel_0 5
		sel_2 295
	)
)
