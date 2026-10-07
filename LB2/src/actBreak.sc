;;; Sierra Script 1.0 - (do not remove this comment)
(script# 26)
(include sci.sh)
(use Main)
(use LBRoom)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	actBreak 0
)

(local
	local0
	local1
	local2
	local3 =  5
	local4 =  12
	local5 =  43
	local6 =  58
	local7 =  61
	local8
)
(instance actBreak of LBRoom
	(properties
		sel_20 {actBreak}
		sel_408 780
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 26)
		(proc958_0 132 30)
		(gGame sel_587:)
		(switch global123
			(0 (= local0 230))
			(1
				(= local8 (/ (* global15 100) local3))
				(= local0 330)
			)
			(2
				(= local8 (/ (* global15 100) local4))
				(= local0 18)
			)
			(3
				(= local8 (/ (* global15 100) local5))
				(= local0 (if (== gGSel_40 620) 610 else 510))
			)
			(4
				(= local8 (/ (* global15 100) local6))
				(= local0 18)
			)
			(5
				(= local8 (/ (* global15 100) local7))
				(= local0 750)
			)
		)
		(super sel_110: &rest)
		(cond 
			((and (< -1 local8) (< local8 21)) (= local1 2) (= local2 global131) (++ global131))
			((and (< 20 local8) (< local8 41)) (= local1 3) (= local2 global132) (++ global132))
			((and (< 40 local8) (< local8 61)) (= local1 4) (= local2 global133) (++ global133))
			((and (< 60 local8) (< local8 81)) (= local1 5) (= local2 global134) (++ global134))
			((and (< 80 local8) (< local8 101)) (= local1 6) (= local2 global135) (++ global135))
		)
		(actView sel_110: sel_4: global123)
		(gSel_608 sel_40: 30 sel_99: 1 sel_3: -1 sel_39:)
		(self sel_146: sBreakIt)
	)
)

(instance sBreakIt of Script
	(properties
		sel_20 {sBreakIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(global2 sel_408: 26 sel_417: 26)
				(= sel_136 2)
			)
			(1
				(actView sel_312: MoveTo 150 115 self)
			)
			(2
				(titleView sel_110: sel_4: global123)
				(= sel_137 3)
			)
			(3
				(actView sel_312: MoveTo 150 49 self)
			)
			(4
				(titleView sel_312: MoveTo 150 115 self)
			)
			(5
				(gSel_608 sel_170: 0 40 10 1)
				(= sel_137 3)
			)
			(6
				(actView sel_111:)
				(titleView sel_312: MoveTo 150 49 self)
			)
			(7
				(titleView sel_111:)
				(global2 sel_417: 780 10)
				(= sel_137 2)
			)
			(8
				(gNarrator sel_537: 120)
				(if (and local1 local2 global123)
					(gLb2Messager sel_295: local1 0 0 local2 self)
				else
					(= sel_136 1)
				)
			)
			(9
				(gSel_608 sel_170: 0 10 20 1)
				(++ global123)
				(= global124 0)
				(global2 sel_399: local0)
				(self sel_111:)
			)
		)
	)
)

(instance actView of Actor
	(properties
		sel_20 {actView}
		sel_1 150
		sel_0 141
		sel_2 26
	)
	
	(method (sel_300 param1)
		(if (== param1 2)
			(sBreakIt sel_144: 8)
		else
			(super sel_300: param1)
		)
	)
)

(instance titleView of Actor
	(properties
		sel_20 {titleView}
		sel_1 150
		sel_0 161
		sel_2 26
		sel_3 1
	)
)
