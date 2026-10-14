;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 989)
(include sci.sh)
(use Main)
(use System)

(class Sound of Obj
	(properties
		name {Sound}
		nodePtr 0
		handle 0
		flags 0
		number 0
		vol 127
		priority 0
		loop 1
		signal 0
		prevSignal 0
		dataInc 0
		min 0
		sec 0
		frame 0
		client 0
		owner 0
	)

	(method (new param1)
		((super new:) owner: (if argc param1 else 0) yourself:)
	)

	(method (init)
		(= prevSignal (= signal 0))
		(gSounds add: self)
		(if (not (and (DoSound sndGET_AUDIO_CAPABILITY) (& flags $0004)))
			(DoSound sndINIT self)
		)
	)

	(method (dispose)
		(gSounds delete: self)
		(if nodePtr
			(DoSound sndDISPOSE self)
			(= nodePtr 0)
		)
		(super dispose:)
	)

	(method (play param1 &tmp temp0)
		(= temp0 argc)
		(if (and argc (IsObject [param1 (- argc 1)]))
			(= client [param1 (= temp0 (- argc 1))])
		else
			(= client 0)
		)
		(self init:)
		(if (not loop)
			(= loop 1)
		)
		(if temp0
			(= vol param1)
		else
			(= vol 127)
		)
		(if (and (DoSound sndGET_AUDIO_CAPABILITY) (& flags $0004))
			(DoAudio audPLAY number)
		else
			(DoSound sndPLAY self 0)
		)
	)

	(method (stop)
		(cond
			((and (DoSound sndGET_AUDIO_CAPABILITY) (& flags $0004))
				(DoAudio audSTOP)
			)
			(handle
				(DoSound sndUPDATE_CUES self)
				(DoSound sndSTOP self)
			)
		)
	)

	(method (pause param1)
		(if (not argc)
			(= param1 1)
		)
		(DoSound sndPAUSE (if (self isMemberOf: Sound) self else 0) param1)
	)

	(method (hold param1)
		(if (not argc)
			(= param1 1)
		)
		(DoSound sndSET_HOLD self param1)
	)

	(method (release)
		(DoSound sndSET_HOLD self 0)
	)

	(method (fade param1 param2 param3 param4 &tmp temp0)
		(if (and (DoSound sndGET_AUDIO_CAPABILITY) (& flags $0004))
			(DoAudio audSTOP)
		else
			(= temp0 argc)
			(if (and argc (IsObject [param1 (- argc 1)]))
				(= client [param1 (= temp0 (- argc 1))])
			)
			(if temp0
				(DoSound sndFADE self param1 param2 param3 param4)
			else
				(DoSound sndFADE self 0 25 10 1)
			)
		)
	)

	(method (mute param1)
		(if (not argc)
			(= param1 1)
		)
		(DoSound 13 self param1) ; Mute
	)

	(method (setVol param1)
		(DoSound sndSET_VOLUME self param1)
	)

	(method (setPri param1)
		(DoSound sndSET_PRIORITY self param1)
	)

	(method (setLoop param1)
		(DoSound sndSET_LOOP self param1)
	)

	(method (send param1 param2 param3 param4)
		(if (and (<= 1 param1) (<= param1 15))
			(if (< param2 128)
				(DoSound sndSEND_MIDI self param1 176 param2 param3)
			else
				(DoSound sndSEND_MIDI self param1 param2 param3 param4)
			)
		)
	)

	(method (check)
		(if (and (DoSound sndGET_AUDIO_CAPABILITY) (& flags $0004))
			(if (and (!= prevSignal -1) (== (DoAudio audPOSITION) -1))
				(= prevSignal -1)
				(= signal 0)
				(if (IsObject client)
					(client cue: self)
				)
			)
		else
			(if handle
				(DoSound sndUPDATE_CUES self)
			)
			(if signal
				(= prevSignal signal)
				(= signal 0)
				(if (IsObject client)
					(client cue: self)
				)
			)
		)
	)

	(method (clean param1)
		(if (or (not owner) (== owner param1))
			(self dispose:)
		)
	)

	(method (playBed param1 &tmp temp0)
		(= temp0 argc)
		(if (and argc (IsObject [param1 (- argc 1)]))
			(= client [param1 (= temp0 (- argc 1))])
		else
			(= client 0)
		)
		(self init:)
		(if (not loop)
			(= loop 1)
		)
		(if temp0
			(= vol param1)
		else
			(= vol 127)
		)
		(DoSound sndPLAY self 1)
	)

	(method (changeState)
		(DoSound sndUPDATE self)
	)
)
