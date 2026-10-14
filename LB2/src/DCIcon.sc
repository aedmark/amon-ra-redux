;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 967)
(include sci.sh)
(use Dialog)
(use Motion)

(class DCIcon of DIcon
	(properties
		name {DCIcon}
		cycler 0
		cycleSpeed 6
		signal 0
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)

	(method (dispose)
		(if cycler
			(cycler dispose:)
		)
		(super dispose:)
	)

	(method (cycle &tmp temp0)
		(if cycler
			(= temp0 cel)
			(cycler doit:)
			(if (!= cel temp0)
				(self draw:)
			)
		)
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)
)
