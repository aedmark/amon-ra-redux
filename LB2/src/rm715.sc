;;; Sierra Script 1.0 - (do not remove this comment)
(script# 715)
(include sci.sh)
(use Main)
(use LBRoom)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm715 0
)

(local
	local0
)
(instance rm715 of LBRoom
	(properties
		sel_20 {rm715}
		sel_408 715
		sel_28 12
		sel_410 720
		sel_412 710
	)
	
	(method (sel_110)
		(gEgo
			sel_584: 1
			sel_2: 715
			sel_3: 3
			sel_4: 0
			sel_153: 121 142
			sel_110:
		)
		(proc958_0 132 710 712 713)
		(proc958_0 128 711 712 713 715 710 714 716)
		(super sel_110:)
		(WrapMusic sel_110: 1 1710 1712 1713)
		(gIconBar sel_233: 7)
		(tut sel_317:)
		(rameses sel_110:)
		(sunnie1 sel_110: sel_161: Fwd)
		(sunnie2 sel_110: sel_161: Fwd)
		(sunnie3 sel_110: sel_161: Fwd)
		(sunnie4 sel_110: sel_161: Fwd)
		(sunnie5 sel_110: sel_161: Fwd)
		(sunnie6 sel_110: sel_161: Fwd)
		(sunnie7 sel_110: sel_161: Fwd)
		(sunnie8 sel_110: sel_161: Fwd)
		(sunnie9 sel_110: sel_161: Fwd)
		(sunnie10 sel_110: sel_161: Fwd)
		(global2 sel_146: sQuestion)
	)
	
	(method (sel_111)
		(gGameMusic2 sel_170:)
		(super sel_111: &rest)
	)
)

(instance sQuestion of Script
	(properties
		sel_20 {sQuestion}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1 (= sel_139 180))
			(2
				(sunnie1 sel_161: End self)
				(sunnie2 sel_161: End)
				(sunnie3 sel_161: End self)
				(sunnie4 sel_161: End)
				(sunnie5 sel_161: End self)
				(sunnie6 sel_161: End)
				(sunnie7 sel_161: End)
				(sunnie8 sel_161: End)
				(sunnie9 sel_161: End)
				(sunnie10 sel_161: End)
			)
			(3)
			(4)
			(5
				(sunnie1 sel_317:)
				(sunnie2 sel_317:)
				(sunnie3 sel_317:)
				(sunnie4 sel_317:)
				(sunnie5 sel_317:)
				(sunnie6 sel_317:)
				(sunnie7 sel_317:)
				(sunnie8 sel_317:)
				(sunnie9 sel_317:)
				(sunnie10 sel_317:)
				(WrapMusic sel_111:)
				(= sel_136 1)
			)
			(6
				(gLb2Messager sel_295: 1)
				(= sel_136 1)
			)
			(7
				(global2 sel_422: (ScriptID 20 0))
				(= local0 (not (StrCmp @global136 {WOMB})))
				(= sel_136 1)
			)
			(8
				(gIconBar sel_233: 7)
				(if local0
					(gGame sel_87: 1 156)
					(= global136 0)
					(gLb2Messager sel_295: 1 0 2)
					(= sel_136 1)
				else
					(global2 sel_146: sDeath)
				)
			)
			(9
				(global2 sel_422: (ScriptID 20 0))
				(= local0 (not (StrCmp @global136 {TOMB})))
				(= sel_136 1)
			)
			(10
				(gIconBar sel_233: 7)
				(if local0
					(gGame sel_87: 1 157)
					(gLb2Messager sel_295: 1 0 3)
					(= sel_136 1)
				else
					(global2 sel_146: sDeath)
				)
			)
			(11 (rameses sel_161: End self))
			(12
				(rameses sel_313:)
				(= sel_136 1)
			)
			(13
				(gEgo
					sel_585: 831
					sel_3: 1
					sel_103: 1
					sel_104: 110
					sel_105: 110
					sel_253: 0 self
				)
			)
			(14
				(gEgo sel_155: 3 sel_312: MoveTo 123 159 self)
			)
			(15
				(gEgo sel_63: 9 sel_312: MoveTo 130 159 self)
			)
			(16
				(gEgo sel_155: 0 sel_312: MoveTo 152 186 self)
			)
			(17
				(gEgo sel_349: 2)
				(global2 sel_399: 720)
				(self sel_111:)
			)
		)
	)
)

(instance sDeath of Script
	(properties
		sel_20 {sDeath}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (rameses sel_161: End self))
			(1
				(gLb2Messager sel_295: 1 0 1 1)
				(= sel_136 1)
			)
			(2
				(rameses sel_155: 1 sel_156: 0 sel_161: CT 5 1 self)
			)
			(3
				(wrap sel_110:)
				(rameses sel_63: 15 sel_161: CT 0 1 self)
			)
			(4
				(rameses sel_63: -1 sel_161: CT 5 1 self)
			)
			(5
				(wrap sel_156: (+ (wrap sel_4?) 1))
				(rameses sel_63: 15 sel_161: CT 0 1 self)
			)
			(6
				(rameses sel_63: -1 sel_161: CT 5 1 self)
			)
			(7
				(wrap sel_156: (+ (wrap sel_4?) 1))
				(rameses sel_63: 15 sel_161: CT 0 1 self)
			)
			(8
				(rameses sel_63: -1 sel_161: CT 5 1 self)
			)
			(9
				(wrap sel_156: (+ (wrap sel_4?) 1))
				(rameses sel_63: 15 sel_161: CT 0 1 self)
			)
			(10
				(rameses sel_63: -1 sel_161: CT 5 1 self)
			)
			(11
				(lauraWrap sel_110:)
				(= sel_139 120)
			)
			(12
				(gNarrator sel_1: 59 sel_0: 30)
				(gLb2Messager sel_295: 1 0 1 2)
				(= sel_136 1)
			)
			(13 (= sel_139 180))
			(14
				(= global145 7)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance tut of Actor
	(properties
		sel_20 {tut}
		sel_1 141
		sel_0 142
		sel_2 716
		sel_3 1
		sel_14 16385
	)
)

(instance rameses of Actor
	(properties
		sel_20 {rameses}
		sel_1 108
		sel_0 142
		sel_2 715
		sel_14 16384
	)
)

(instance sunnie1 of Prop
	(properties
		sel_20 {sunnie1}
		sel_1 27
		sel_0 181
		sel_2 710
		sel_3 1
		sel_14 16384
	)
)

(instance sunnie2 of Prop
	(properties
		sel_20 {sunnie2}
		sel_1 157
		sel_0 189
		sel_2 710
		sel_3 2
		sel_14 16384
	)
)

(instance sunnie3 of Prop
	(properties
		sel_20 {sunnie3}
		sel_1 65
		sel_0 181
		sel_2 711
		sel_3 2
		sel_14 16384
	)
)

(instance sunnie4 of Prop
	(properties
		sel_20 {sunnie4}
		sel_1 203
		sel_0 190
		sel_2 711
		sel_3 1
		sel_14 16384
	)
)

(instance sunnie5 of Prop
	(properties
		sel_20 {sunnie5}
		sel_1 47
		sel_0 188
		sel_2 712
		sel_3 1
		sel_14 16384
	)
)

(instance sunnie6 of Prop
	(properties
		sel_20 {sunnie6}
		sel_1 94
		sel_0 179
		sel_2 712
		sel_3 2
		sel_14 16384
	)
)

(instance sunnie7 of Prop
	(properties
		sel_20 {sunnie7}
		sel_1 183
		sel_0 188
		sel_2 713
		sel_3 2
		sel_14 16384
	)
)

(instance sunnie8 of Prop
	(properties
		sel_20 {sunnie8}
		sel_1 123
		sel_0 187
		sel_2 713
		sel_3 1
		sel_14 16384
	)
)

(instance sunnie9 of Prop
	(properties
		sel_20 {sunnie9}
		sel_1 96
		sel_0 189
		sel_2 714
		sel_3 1
		sel_14 16384
	)
)

(instance sunnie10 of Prop
	(properties
		sel_20 {sunnie10}
		sel_1 137
		sel_0 183
		sel_2 714
		sel_3 2
		sel_14 16384
	)
)

(instance wrap of View
	(properties
		sel_20 {wrap}
		sel_1 119
		sel_0 101
		sel_2 715
		sel_3 4
		sel_60 11
		sel_14 17
	)
)

(instance lauraWrap of View
	(properties
		sel_20 {lauraWrap}
		sel_1 70
		sel_0 59
		sel_2 715
		sel_3 2
		sel_60 15
		sel_14 16401
	)
)
