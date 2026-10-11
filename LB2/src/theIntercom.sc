;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 562)
(include sci.sh)
(use Main)
(use Inset)
(use Timer)
(use Sound)
(use Actor)

(public
	theIntercom 0
)

(procedure (localproc_0)
	(olympiaButton sel_156: 1)
	(yvetteButton sel_156: 1)
	(ernieButton sel_156: 1)
	(heimlichButton sel_156: 1)
	(nextButton sel_156: 1)
	(lastButton sel_156: 1)
)

(procedure (localproc_1)
	(DisposeScript 1892)
	(DisposeScript 1889)
	(DisposeScript 1885)
	(DisposeScript 1888)
	(DisposeScript 1893)
	(DisposeScript 1890)
)

(instance theIntercom of Inset
	(properties
		sel_20 {theIntercom}
		sel_2 563
		sel_3 3
		sel_1 105
		sel_0 109
		sel_570 1
		sel_214 562
		sel_213 54
	)

	(method (sel_110)
		(super sel_110: &rest)
		(onOff sel_110:)
		(sendReceive sel_110:)
		(olympiaButton sel_110:)
		(yvetteButton sel_110:)
		(ernieButton sel_110:)
		(heimlichButton sel_110:)
		(nextButton sel_110:)
		(lastButton sel_110:)
	)

	(method (sel_111)
		(localproc_1)
		(sFX sel_111:)
		(super sel_111:)
		(DisposeScript 562)
	)

	(method (sel_300 param1)
		(switch param1
			(2
				(if (and (== (onOff sel_4:) 2) (== (sendReceive sel_4:) 2))
					(gMessager sel_295: 54 param1 0 (Random 2 7) 0 562)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance onOff of Prop
	(properties
		sel_20 {onOff}
		sel_1 133
		sel_0 133
		sel_213 57
		sel_214 562
		sel_2 563
		sel_3 3
		sel_4 1
		sel_60 14
		sel_14 16
	)

	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1:))
			(= temp1 (param1 sel_0:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(<= (- sel_1 8) temp0 (+ sel_1 16))
				(<= (- sel_0 6) temp1 (+ sel_0 6))
				1
			)
		)
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(if (== sel_4 1)
					(self sel_156: 2)
				else
					(self sel_156: 1)
				)
				(sFX sel_40: 558 sel_99: 1 sel_155: 1 sel_39:)
			)
			(8
				(if (== sel_4 2)
					(gMessager sel_295: sel_213 param1 8 0 0 562)
				else
					(gMessager sel_295: sel_213 param1 9 0 0 562)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(instance sendReceive of Prop
	(properties
		sel_20 {sendReceive}
		sel_1 139
		sel_0 117
		sel_213 77
		sel_214 562
		sel_2 563
		sel_3 3
		sel_4 1
		sel_60 14
		sel_14 16
	)

	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1:))
			(= temp1 (param1 sel_0:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(<= (- sel_1 8) temp0 (+ sel_1 16))
				(<= (- sel_0 6) temp1 (+ sel_0 6))
				1
			)
		)
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(if (== (self sel_4:) 1)
					(self sel_156: 2)
				else
					(self sel_156: 1)
				)
				(sFX sel_40: 558 sel_99: 1 sel_155: 1 sel_39:)
			)
			(8
				(if (== sel_4 2)
					(gMessager sel_295: sel_213 param1 6 0 0 562)
				else
					(gMessager sel_295: sel_213 param1 7 0 0 562)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)

(class Button of Prop
	(properties
		sel_20 {Button}
		sel_213 84
		sel_214 562
		sel_2 563
		sel_3 3
		sel_4 1
		sel_60 14
		sel_14 16
	)

	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1:))
			(= temp1 (param1 sel_0:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(<= (- sel_1 8) temp0 (+ sel_1 36))
				(<= (- sel_0 2) temp1 (+ sel_0 2))
				1
			)
		)
	)

	(method (sel_300 param1)
		(switch param1
			(4
				(if (== sel_4 1)
					(localproc_0)
					(localproc_1)
					(self sel_677:)
				else
					(self sel_156: 1)
				)
				(sFX sel_40: 558 sel_99: 1 sel_155: 1 sel_39:)
			)
			(8
				(if (== sel_4 2)
					(gMessager sel_295: sel_213 param1 12 0 0 562)
				else
					(gMessager sel_295: sel_213 param1 13 0 0 562)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)

	(method (sel_145)
		(if (and (== (onOff sel_4:) 2) (== (sendReceive sel_4:) 1))
			(sFX sel_40: 567 sel_99: 1 sel_155: 1 sel_39:)
			(gMessager sel_295: 54 4 5 0 0 562)
		)
	)

	(method (sel_677)
		(self sel_156: 2)
		((Timer sel_109:) sel_161: self 2)
	)
)

(instance olympiaButton of Button
	(properties
		sel_20 {olympiaButton}
		sel_1 139
		sel_0 135
	)

	(method (sel_145)
		(if (and (== (onOff sel_4:) 2) (== (sendReceive sel_4:) 1))
			(sFX sel_40: 567 sel_99: 1 sel_155: 1 sel_39:)
			(if (IsFlag 51)
				(gMessager sel_295: 54 4 2 0 0 562)
			else
				(gMessager sel_295: 54 4 1 0 0 562)
				(SetFlag 51)
			)
		)
	)
)

(instance yvetteButton of Button
	(properties
		sel_20 {yvetteButton}
		sel_1 140
		sel_0 132
	)

	(method (sel_145)
		(if (and (== (onOff sel_4:) 2) (== (sendReceive sel_4:) 1))
			(sFX sel_40: 567 sel_99: 1 sel_155: 1 sel_39:)
			(if (not (IsFlag 52))
				(SetFlag 52)
				(if (not (IsFlag 5))
					(gMessager sel_295: 54 4 3 0 0 562)
				else
					(gMessager sel_295: 54 4 5 0 0 562)
				)
			else
				(gMessager sel_295: 54 4 2 0 0 562)
			)
		)
	)
)

(instance ernieButton of Button
	(properties
		sel_20 {ernieButton}
		sel_1 141
		sel_0 129
	)

	(method (sel_145)
		(if (and (== (onOff sel_4:) 2) (== (sendReceive sel_4:) 1))
			(sFX sel_40: 567 sel_99: 1 sel_155: 1 sel_39:)
			(if (not (IsFlag 53))
				(SetFlag 53)
				(if (and (not (IsFlag 2)) (not (IsFlag 4)))
					(gMessager sel_295: 54 4 4 0 0 562)
				else
					(gMessager sel_295: 54 4 5 0 0 562)
				)
			else
				(gMessager sel_295: 54 4 2 0 0 562)
			)
		)
	)
)

(instance heimlichButton of Button
	(properties
		sel_20 {heimlichButton}
		sel_1 142
		sel_0 126
	)
)

(instance nextButton of Button
	(properties
		sel_20 {nextButton}
		sel_1 143
		sel_0 123
	)
)

(instance lastButton of Button
	(properties
		sel_20 {lastButton}
		sel_1 144
		sel_0 120
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
