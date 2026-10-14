;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 973)
(include sci.sh)
(use Main)
(use System)

(class Timer of Obj
	(properties
		name {Timer}
		cycleCnt -1
		seconds -1
		ticks -1
		lastTime -1
		client 0
	)

	(procedure (CueClient &tmp who)
		(= who client)
		(= client 0)
		(if (IsObject who)
			(if (who respondsTo: 135)
				(who timer: 0)
			)
			(if (who respondsTo: 145)
				(who cue:)
			)
		)
	)

	(method (new)
		(return
			(if (== self Timer)
				(super new:)
			else
				self
			)
		)
	)

	(method (init param1)
		(= client param1)
		(gTimers add: self)
		(if (param1 respondsTo: 135)
			(if (IsObject (param1 timer:))
				((param1 timer:) dispose:)
			)
			(param1 timer: self)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((!= cycleCnt -1)
				(if (not (-- cycleCnt))
					(CueClient)
				)
			)
			((!= seconds -1)
				(if (!= lastTime (= temp0 (GetTime 1))) ; SysTime12
					(= lastTime temp0)
					(if (not (-- seconds))
						(CueClient)
					)
				)
			)
			((> (- gGameTime ticks) 0)
				(CueClient)
			)
		)
	)

	(method (dispose)
		(if (and (IsObject client) (client respondsTo: 135))
			(client timer: 0)
		)
		(= client 0)
	)

	(method (set param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(if (== (= temp2 gSpeed) 0)
			(= temp2 1)
		)
		(= temp1 (/ (* param2 60) temp2))
		(if (> argc 2)
			(+= temp1 (/ (* param3 3600) temp2))
		)
		(if (> argc 3)
			(+= temp1 (* (/ (* param4 3600) temp2) 60))
		)
		((= temp0
				(if (& -info- $8000)
					(self new:)
				else
					self
				)
			)
			init: param1
			cycleCnt: temp1
		)
		(return temp0)
	)

	(method (setCycle param1 param2 &tmp temp0)
		((= temp0
				(if (& -info- $8000)
					(self new:)
				else
					self
				)
			)
			init: param1
			cycleCnt: param2
		)
		(return temp0)
	)

	(method (setReal param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp1 param2)
		(if (> argc 2)
			(+= temp1 (* param3 60))
		)
		(if (> argc 3)
			(+= temp1 (* param4 3600))
		)
		((= temp0
				(if (& -info- $8000)
					(self new:)
				else
					self
				)
			)
			init: param1
			seconds: temp1
		)
		(return temp0)
	)

	(method (delete)
		(if (== client 0)
			(gTimers delete: self)
			(super dispose:)
		)
	)

	(method (setTicks param1 param2 &tmp temp0)
		(= temp0
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(temp0 ticks: (+ gGameTime param1) init: param2)
		(return temp0)
	)
)

(class TO of Obj
	(properties
		name {TO}
		timeLeft 0
	)

	(method (doit)
		(if timeLeft
			(-- timeLeft)
		)
	)

	(method (set param1)
		(= timeLeft param1)
	)
)
