;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 961)
(include sci.sh)
(use Motion)

(public
	StopWalk 0
)

(class StopWalk of Fwd
	(properties
		name {StopWalk}
		vWalking 0
		vStopped 0
	)

	(method (init param1 param2)
		(if argc
			(= vWalking ((= client param1) view:))
			(if (>= argc 2)
				(= vStopped param2)
			)
		)
		(super init: client)
		(self doit:)
	)

	(method (doit &tmp temp0 temp1)
		(if (client isStopped:)
			(cond
				(
					(and
						(== vStopped -1)
						(!= (client loop:) (- (NumLoops client) 1))
					)
					(= temp0 (client loop:))
					(if (and (= temp1 (client mover:)) (not (temp1 completed:)))
						(client setMotion: 0)
					)
					(super doit:)
					(client loop: (- (NumLoops client) 1) setCel: temp0)
				)
				((and (!= vStopped -1) (== (client view:) vWalking))
					(client view: vStopped)
					(if (and (= temp1 (client mover:)) (not (temp1 completed:)))
						(client setMotion: 0)
					)
					(super doit:)
				)
				((!= vStopped -1)
					(super doit:)
				)
			)
		else
			(switch vStopped
				((client view:)
					(client view: vWalking)
				)
				(-1
					(client setLoop: -1 setCel: -1)
					(if (== (client loop:) (- (NumLoops client) 1))
						(client loop: (client cel:) cel: 0)
					)
				)
			)
			(super doit:)
		)
	)

	(method (dispose)
		(if (== (client view:) vStopped)
			(client view: vWalking)
		)
		(super dispose:)
	)
)
