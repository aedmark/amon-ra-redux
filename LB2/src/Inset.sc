;;; Sierra Script 1.0 - (do not remove this comment)
(script# 923)
(include sci.sh)
(use Main)
(use View)
(use Obj)


(class Inset of Code
	(properties
		sel_20 {Inset}
		sel_408 0
		sel_559 0
		sel_28 100
		sel_2 0
		sel_3 0
		sel_4 0
		sel_1 0
		sel_0 0
		sel_60 14
		sel_141 0
		sel_560 0
		sel_143 0
		sel_166 0
		sel_142 0
		sel_561 0
		sel_562 0
		sel_563 0
		sel_564 0
		sel_565 0
		sel_566 0
		sel_567 0
		sel_568 0
		sel_569 0
		sel_365 0
		sel_570 0
		sel_214 -1
		sel_213 0
		sel_571 0
	)
	
	(method (sel_110 theSel_143 theSel_166 theSel_141)
		(= sel_166 theSel_166)
		(sel_166 sel_365: self)
		(= sel_141 theSel_141)
		(= sel_143 theSel_143)
		(if (and (not sel_408) sel_560) (self sel_572: 1))
		(= sel_561 gSel_561)
		(= sel_562 gSel_562)
		(= sel_563 gSel_563)
		(= sel_564 gLb2MDH)
		(= sel_565 gLb2KDH)
		(= sel_566 gLb2DH)
		(= sel_567 gLb2WH)
		(= sel_568 (global2 sel_259?))
		(global2 sel_259: ((List sel_109:) sel_118: sel_117:))
		((= gSel_561 (EventHandler sel_109:))
			sel_20: {newCast}
			sel_118:
		)
		((= gSel_562 (EventHandler sel_109:))
			sel_20: {newFeatures}
			sel_118: self
		)
		((= gSel_563 (EventHandler sel_109:))
			sel_20: {newATPs}
			sel_118:
		)
		((= gLb2MDH (EventHandler sel_109:))
			sel_20: {newMH}
			sel_118: self
		)
		((= gLb2KDH (EventHandler sel_109:))
			sel_20: {newKH}
			sel_118: self
		)
		((= gLb2DH (EventHandler sel_109:))
			sel_20: {newDH}
			sel_118: self
		)
		((= gLb2WH (EventHandler sel_109:))
			sel_20: {newWH}
			sel_118:
		)
		(gTheDoits sel_118: self)
		(self sel_573:)
	)
	
	(method (sel_57)
		(if sel_142 (sel_142 sel_57:))
		(if (not sel_560) (Animate (sel_561 sel_24?) 0))
	)
	
	(method (sel_111 param1 &tmp theSel_143)
		(if sel_365 (sel_365 sel_111: 0))
		(gSel_562 sel_81: self)
		(gLb2MDH sel_81: self)
		(gLb2KDH sel_81: self)
		(gLb2DH sel_81: self)
		(gLb2WH sel_81: self)
		(gTheDoits sel_81: self)
		(gSel_561 sel_119: 111 sel_119: 81 sel_125: sel_111:)
		(gSel_563 sel_111:)
		(gSel_562 sel_111:)
		(gLb2MDH sel_111:)
		(gLb2KDH sel_111:)
		(gLb2DH sel_111:)
		(gLb2WH sel_111:)
		((global2 sel_259?) sel_111:)
		(sel_166 sel_365: 0)
		(if (== sel_166 global2) (gIconBar sel_177: 7))
		(if (or (not argc) param1) (self sel_574:))
		(global2 sel_259: sel_568)
		(= gSel_561 sel_561)
		(= gSel_563 sel_563)
		(= gSel_562 sel_562)
		(= gLb2MDH sel_564)
		(= gLb2KDH sel_565)
		(= gLb2DH sel_566)
		(= gLb2WH sel_567)
		(if (or (not argc) param1) (gSel_563 sel_57:))
		(if (and (not sel_408) sel_560) (self sel_572: 0))
		(if (and (or (not argc) param1) sel_143)
			(= theSel_143 sel_143)
			(= sel_143 0)
			(theSel_143 sel_145:)
		)
	)
	
	(method (sel_146 param1)
		(if (IsObject sel_142) (sel_142 sel_111:))
		(= sel_142 (if argc param1 else 0))
		(if sel_142 (sel_142 sel_110: self &rest))
	)
	
	(method (sel_133 param1 &tmp [temp0 2])
		(return
			(cond 
				((and sel_365 (sel_365 sel_133: param1)) 0)
				((& (param1 sel_31?) $4000)
					(cond 
						((self sel_218: param1) (param1 sel_73: 1) (self sel_300: (param1 sel_37?)))
						(sel_570 (param1 sel_73: 1) (self sel_111:))
						(else (return 0))
					)
				)
			)
		)
	)
	
	(method (sel_300 param1)
		(if (== sel_214 -1) (= sel_214 gSel_40))
		(if
			(and
				global90
				(Message msgGET sel_214 sel_213 param1 0 1)
			)
			(gLb2Messager sel_295: sel_213 param1 0 0 0 sel_214)
		else
			(gLb2DoVerbCode sel_57: param1 self)
		)
	)
	
	(method (sel_572 param1 &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 (if param1 1000 else -1000))
		(while (< temp0 (gSel_561 sel_86?))
			((gSel_561 sel_64: temp0)
				sel_82: (+ ((gSel_561 sel_64: temp0) sel_82?) temp1)
			)
			(++ temp0)
		)
		(Animate (gSel_561 sel_24?) 0)
	)
	
	(method (sel_573)
		(if (> sel_408 0)
			(DrawPic
				sel_408
				(if sel_559 100 else sel_28)
				(if sel_559 0 else 1)
				global40
			)
		)
		(if sel_2
			(= sel_571
				((inView sel_109:)
					sel_2: sel_2
					sel_3: sel_3
					sel_4: sel_4
					sel_1: sel_1
					sel_0: sel_0
					sel_63: sel_60
					sel_316: 1
					sel_110:
					sel_117:
				)
			)
		)
	)
	
	(method (sel_76)
		(self sel_573:)
		(if sel_365
			((sel_365 sel_563?) sel_57:)
			(sel_365 sel_76:)
		)
	)
	
	(method (sel_574)
		(if sel_2
			(DrawPic (global2 sel_408?) dpOPEN_NO_TRANSITION)
		else
			(DrawPic (global2 sel_408?) sel_28)
		)
		(global2 sel_28: sel_569)
		(if (!= global36 -1)
			(DrawPic
				global36
				dpOPEN_NO_TRANSITION
				dpNO_CLEAR
				global40
			)
		)
		(if (global2 sel_365:) ((global2 sel_365:) sel_76:))
	)
	
	(method (sel_422 param1 param2 param3)
		(if sel_365 (sel_365 sel_111:))
		(if (and argc param1)
			(param1
				sel_110:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)
	
	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1?))
			(= temp1 (param1 sel_0?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(if sel_2
				(return (sel_571 sel_218: param1 param2))
			else
				(return 1)
			)
		)
	)
)

(instance inView of View
	(properties
		sel_20 {inView}
	)
	
	(method (sel_133)
		(return 0)
	)
)
